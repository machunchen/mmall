package com.chen.mmall003.controller;


import com.chen.mmall003.entity.Orders;
import com.chen.mmall003.entity.User;
import com.chen.mmall003.service.CartService;
import com.chen.mmall003.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 建强
 * @since 2021-05-29
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @PostMapping("/settlement3")
    public ModelAndView settlement3(Orders orders, HttpSession session, String address, String remark){
        User user = (User) session.getAttribute("user");
        orderService.save(orders,user,address,remark);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("settlement3");
        modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        modelAndView.addObject("orders",orders);
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView list(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderList");
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("list",orderService.findAllOrderVOByUserId(user.getId()));
        modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        return modelAndView;
    }

}

