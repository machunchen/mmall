package com.chen.mmall003.vo;

import lombok.Data;

import java.util.List;

/**
 * vo(view object视图对象)
 * 把数据库对象属性转为前端对应的要求
 */
@Data
public class ProductCategoryVO {
    private Integer id;
    private String name;
    private List<ProductCategoryVO> children;
    private String bannerImg;
    private String topImg;
    private List<ProductVO> productVOList;

    public ProductCategoryVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
