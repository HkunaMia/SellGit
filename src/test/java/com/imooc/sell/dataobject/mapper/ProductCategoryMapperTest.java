package com.imooc.sell.dataobject.mapper;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("category_name","秋季限定");
        map.put("category_type",9);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void inserByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("冬季限定");
        productCategory.setCategoryType(11);
        int i = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,i);

    }

    @Test
    public void findByCategoryType(){
        ProductCategory category = mapper.findByCategoryType(11);
        Assert.assertNotNull(category);
    }

    @Test
    public void updateBycategoryType(){
        int i = mapper.updateBycategoryType("冬季特卖", 11);
        assertEquals(1,i);
    }

    @Test
    public void selectByCategoryType(){
        ProductCategory category = mapper.selectByCategoryType(9);
        Assert.assertNotNull(category);
    }
}