package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import com.imooc.sell.utils.EnumUtil;
import com.imooc.sell.utils.serializer.Date2longSerializer;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: sell
 * @description:与orderMaster对应的过渡类
 * @author: ma ru
 * @create: 2019-08-26 17:24
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)//当内容为空时不返回给前端
public class OrderDTO {
    private  String orderId;

    private  String buyerName;

    private String buyerPhone;

    private String  buyerAddress;

    private String  buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    @JsonSerialize(using = Date2longSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2longSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;//每条orderMaster可能包含多条detail

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}