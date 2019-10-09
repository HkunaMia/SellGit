package com.imooc.sell.enums;

import lombok.Getter;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-08-26 17:47
 */
@Getter
public enum  ResultEnum {

    SUCCESS(0,"成功"),

    PARAM_ERROR(1,"参数不正确"),

    PRODUCT_NOT_EXIST(10,"商品不存在"),

    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),

    ORDER_NOT_EXIST(12,"订单不存在"),

    ORDER_DETAIL_NOT_EXIST(13,"订单详情不存在"),

    ORDER_STATUS_ERROR(14,"订单状态错误"),

    ORDER_UPDATE_FAIL(15,"订单状态更新失败"),

    ORDER_DELETE_EMPTY(16,"订单中无商品"),

    ORDER_PAY_STATUS_ERROR(17,"支付状态不正确"),

    CART_IS_EMPTY(18,"购物车为空"),

    ORDER_OWNER_ERROR(19,"非当前用户订单"),

    WECHAT_MP_ERROR(20,"微信公众账号错误"),

    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21,"微信异步通知金额校验不通过"),

    ORDER_CANCEL_SUCCESS(22,"订单取消成功"),

    ORDER_FINISH_SUCCESS(23,"订单完结成功"),

    product_status_error(24,"商品状态不正确"),

    LOGIN_FAIL(25,"卖家登录失败"),

    LOGOUT_SUCCESS(26,"登出成功"),

            ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }


}