package com.imooc.sell.dto;

import lombok.Data;
import sun.dc.pr.PRError;

/**
 * @program: sell
 * @description:购物车类，包含商品ID和下单数量
 * @author: ma ru
 * @create: 2019-08-26 20:38
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}