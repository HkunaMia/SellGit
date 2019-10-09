package com.imooc.sell.converter;

import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-08-27 16:20
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
//        List<OrderDTO> orderDTOS = new ArrayList<>();
//        for (OrderMaster orderMaster : orderMasterList) {
//            OrderDTO convert = convert(orderMaster);
//            orderDTOS.add(convert);
//        }
        return orderMasterList.stream().map(e ->
        convert(e)
        ).collect(Collectors.toList());
    }
}