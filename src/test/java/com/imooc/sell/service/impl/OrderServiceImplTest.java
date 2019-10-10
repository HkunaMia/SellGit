package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import com.imooc.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    OrderService orderService = new OrderServiceImpl();

    private  final String BUYER_OPENID = "1101110";
    private final String ORDER_ID = "1566892381732736968";
    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("郭芙蓉");
        orderDTO.setBuyerAddress("同福客栈");
        orderDTO.setBuyerPhone("15091396542");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(2);
        orderDetails.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetails);

        OrderDTO orderDTO1 = orderService.create(orderDTO);
        log.info("【创建订单】 result={}",orderDTO1);
        Assert.assertNotNull(orderDTO1);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO one = orderService.findOne(ORDER_ID);
        Assert.assertEquals(ORDER_ID ,one.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> list = orderService.findList(BUYER_OPENID, request);
        Assert.assertNotEquals(0,list.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO cancel = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCLE.getCode(),cancel.getOrderStatus());
    }

    @Test
    public void finfish() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO cancel = orderService.finfish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),cancel.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO paid = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),paid.getPayStatus());
    }

    @Test
    public void list(){
        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> list = orderService.findList(request);
        Assert.assertNotEquals(0,list.getTotalElements());
    }

}