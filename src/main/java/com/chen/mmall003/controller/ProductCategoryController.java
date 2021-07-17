package com.chen.mmall003.controller;


import com.chen.mmall003.entity.User;
import com.chen.mmall003.service.CartService;
import com.chen.mmall003.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 建强
 * @since 2021-05-29
 */
@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private CartService cartService;

    /**
     * 将查询到的数据填充到main.html
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("list",productCategoryService.getAllProductCategoryVO());
        User user = (User)session.getAttribute("user");
        if(user == null){
            modelAndView.addObject("cartList",new ArrayList<>());
        }else{
            modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        }
        return modelAndView;
    }

}

