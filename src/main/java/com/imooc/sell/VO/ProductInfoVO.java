package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: sell
 * @description: 商品详情
 * @author: ma ru
 * @create: 2019-08-23 12:52
 */
@Data
public class ProductInfoVO implements Serializable {


    private static final long serialVersionUID = 1192721805912686397L;
    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}