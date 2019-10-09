package com.imooc.sell.dao;

import com.imooc.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456");
        orderDetail.setOrderId("154252");
        orderDetail.setProductIcon("http://...");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("榴莲蛋糕");
        orderDetail.setProductPrice(new BigDecimal(55));
        orderDetail.setProductQuantity(2);
        OrderDetail orderDetail1 = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(orderDetail1);
    }
    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> byOrderId = orderDetailDao.findByOrderId("154252");
        Assert.assertNotEquals(0,byOrderId.size());
    }

}