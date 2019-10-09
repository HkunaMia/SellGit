package com.imooc.sell.service.impl;

import com.imooc.sell.dao.SellerInfoDao;
import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-10-03 19:58
 */

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;


    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }
}