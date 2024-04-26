package com.jsu.goods.entity;

import lombok.Data;

@Data
public class Goods {
    private int id;             // 商品id
    private String count;      // 已砍商品的数量
    private String goodsName; // 商品名称
    private String goodsPic;  // 商品图片
}

