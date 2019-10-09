package com.imooc.sell.dao;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class )
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao dao;

    private  final String OPENID = "110110";

    @Test
    public void saveTest(){
        OrderMaster orderMaster =new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("猪猪");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setBuyerPhone("15091093653");
        orderMaster.setOrderAmount(new BigDecimal(56));
        orderMaster.setBuyerAddress("北门");
        OrderMaster save = dao.save(orderMaster);
        Assert.assertNotNull(save);
    }
    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request = new PageRequest(0,1);
        Page<OrderMaster> byBuyerOpenid = dao.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0,byBuyerOpenid.getTotalElements());
//        System.out.println(byBuyerOpenid.getTotalElements());
    }

}