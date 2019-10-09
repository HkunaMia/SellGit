package com.imooc.sell.dao;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {


    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest() {
        ProductCategory productCategory =productCategoryDao.findOne(1);
        System.out.println(productCategory);
    }

    @Test
    @Transactional
//    transactional用于回滚
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("女生最爱",4);
        ProductCategory productCategory1 = productCategoryDao.save(productCategory);
        Assert.assertNotNull(productCategory);
//        Assert.assertNotEquals(null,productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3);
        List<ProductCategory> byCategoryTypeIn = productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,byCategoryTypeIn.size());
    }
}