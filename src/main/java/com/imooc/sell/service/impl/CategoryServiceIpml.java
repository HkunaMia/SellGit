package com.imooc.sell.service.impl;

import com.imooc.sell.dao.ProductCategoryDao;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-08-22 15:43
 */

@Service
public class CategoryServiceIpml implements CategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

//    @Autowired
//    com.imooc.sell.dataobject.dao.ProductCategoryDao categoryDao;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        /*
        * 原：查不到会返回null
        * 使用.get方法会抛异常
        * */
        return productCategoryDao.findById(categoryId).orElse(null);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTyprList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTyprList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}