package com.chen.mmall003.service;

import com.chen.mmall003.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.mmall003.vo.CartVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 建强
 * @since 2021-05-29
 */
public interface CartService extends IService<Cart> {

    public List<CartVO> findAllCartVOByUserId(Integer id);
}
