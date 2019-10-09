package com.imooc.sell.dao;

import com.imooc.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoDao extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openid);

}
