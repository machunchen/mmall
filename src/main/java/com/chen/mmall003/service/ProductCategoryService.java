package com.chen.mmall003.service;

import com.chen.mmall003.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.mmall003.vo.ProductCategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 建强
 * @since 2021-05-29
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    public List<ProductCategoryVO> getAllProductCategoryVO();
}
