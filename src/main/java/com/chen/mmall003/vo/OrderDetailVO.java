package com.chen.mmall003.vo;

import lombok.Data;

@Data
public class OrderDetailVO {
    private String name;
    private String fileName;
    private Integer quantity;
    private Float price;
    private Float cost;
}
