package com.chen.mmall003.service;

import com.chen.mmall003.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.mmall003.entity.User;
import com.chen.mmall003.vo.OrderVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 建强
 * @since 2021-05-29
 */
public interface OrderService extends IService<Orders> {

    public boolean save(Orders orders, User user, String address, String remark);

    public List<OrderVO> findAllOrderVOByUserId(Integer id);
}
