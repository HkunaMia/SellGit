package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-08-25 22:29
 */

@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;

    private String orderId;

    private String  productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;

}
