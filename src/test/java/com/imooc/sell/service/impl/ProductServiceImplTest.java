package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.service.ProductService;
import org.assertj.core.api.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne("123456");
        org.junit.Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> upAll = productService.findUpAll();
        org.junit.Assert.assertNotEquals(0,upAll.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> all = productService.findAll(request);
        org.junit.Assert.assertNotNull(all);
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("重庆火锅");
        productInfo.setProductPrice(new BigDecimal(50));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        productInfo.setProductDescription("重庆老火锅");
        productInfo.setProductIcon("http://......");
        productInfo.setCategoryType(ProductStatusEnum.UP.getCode());
        ProductInfo productInfo1 = productService.save(productInfo);
        org.junit.Assert.assertNotNull(productInfo1);
    }

    @Test
    public void onSale(){
        ProductInfo productInfo = productService.onSale("123456");
        assertEquals(ProductStatusEnum.UP,productInfo.getProductStatusEnum());
    }

    @Test
    public void offSale(){
        ProductInfo productInfo = productService.offSale("123456");
        assertEquals(ProductStatusEnum.DOWN,productInfo.getProductStatusEnum());
    }

}