package com.imooc.sell.service;

import com.imooc.sell.dao.OrderMasterDao;
import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-08-26 17:19
 */

public interface  OrderService {
//    创建订单
    OrderDTO create(OrderDTO orderDTO);
//    查询单个订单
    OrderDTO findOne(String orderId);
//    查询订单列表
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
//    取消订单
    OrderDTO cancel(OrderDTO orderDTO);
//    完结订单
    OrderDTO finfish(OrderDTO orderDTO);
//    支付订单
    OrderDTO paid(OrderDTO orderDTO );
    //    查询订单列表
    Page<OrderDTO> findList(Pageable pageable);

}