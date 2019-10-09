package com.imooc.sell.dataobject.dao;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.mapper.ProductCategoryMapper;
import org.apache.coyote.OutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-10-07 10:36
 */
public class ProductCategoryDao {

    @Autowired
    private ProductCategoryMapper mapper;

    public int insertByCategoryType(Map<String ,Object> map){
        return mapper.insertByMap(map);
    }
}