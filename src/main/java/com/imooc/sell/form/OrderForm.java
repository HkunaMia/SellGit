package com.imooc.sell.form;

import lombok.Data;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javax.validation.constraints.NotEmpty;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-08-28 10:40
 */
@Data
public class OrderForm {
    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}