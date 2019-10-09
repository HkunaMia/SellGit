package com.imooc.sell.service.impl;

import com.imooc.sell.dao.OrderMasterDao;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.service.BuyerService;
import com.imooc.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.awt.im.InputMethodWindow;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-08-28 15:10
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        return orderDTO;
    }

    @Override
    public OrderDTO cancleOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if(orderDTO == null){
            log.error("【取消订单】 订单为空，orderId = {}",openid);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    public OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO one = orderService.findOne(orderId);
        if(one == null){
            return null;
        }
//        判断是否是自己的订单
        if(!one.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单详情】订单openID不一致 openid={} orderDto={}",openid,one);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return one;
    }
}