package com.imooc.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-09-24 22:03
 */
@Data
public class ProductForm {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;

}