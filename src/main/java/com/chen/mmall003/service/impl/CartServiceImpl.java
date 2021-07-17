package com.chen.mmall003.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chen.mmall003.entity.Cart;
import com.chen.mmall003.entity.Product;
import com.chen.mmall003.enums.ResultEnum;
import com.chen.mmall003.exception.MallException;
import com.chen.mmall003.mapper.CartMapper;
import com.chen.mmall003.mapper.ProductMapper;
import com.chen.mmall003.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.mmall003.vo.CartVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 建强
 * @since 2021-05-29
 */
@Service
@Slf4j //输出日志
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean save(Cart entity) {
        //扣库存
        Product product = productMapper.selectById(entity.getProductId());
        Integer stock = product.getStock() - entity.getQuantity();
        if(stock < 0){
            log.error("【添加购物车】库存不足！stock={}",stock);
            throw new MallException(ResultEnum.STOCK_ERROR);
        }
        product.setStock(stock);
        /**
         * 原本是返回cartMapper.insert(entity)即return cartMapper.insert(entity)
         * 但要求返回的是boolean我们这样提供的则是Integer
         * 所以我们做个判断如果是（==1）则返回true
         * 否则返回false
         */
        productMapper.updateById(product);
        if(cartMapper.insert(entity) == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<CartVO> findAllCartVOByUserId(Integer id) {
        List<CartVO> cartVOList = new ArrayList<>();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",id);
        List<Cart> cartList = cartMapper.selectList(wrapper);
        for (Cart cart : cartList) {
            CartVO cartVO = new CartVO();
            Product product = productMapper.selectById(cart.getProductId());
            BeanUtils.copyProperties(product,cartVO);
            BeanUtils.copyProperties(cart,cartVO);
            cartVOList.add(cartVO);
        }
        return cartVOList;
    }
}
