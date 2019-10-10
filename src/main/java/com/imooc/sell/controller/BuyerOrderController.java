package com.imooc.sell.controller;

import ch.qos.logback.core.rolling.helper.RenameUtil;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.converter.OrderForm2OrderDTOConverter;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.OrderForm;
import com.imooc.sell.service.BuyerService;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.service.impl.BuyerServiceImpl;
import com.imooc.sell.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.omg.SendingContext.RunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: sell
 * @description:买家订单
 * @author: ma ru
 * @create: 2019-08-28 10:32
 */

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;


//    创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("【订单创建】参数不正确，orderForm = {}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult
                    .getFieldError()
                    .getDefaultMessage());
        }
        OrderDTO orderDTO =new OrderDTO();
        orderDTO =  OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty((orderDTO.getOrderDetailList()))){
            log.error("【创建订单】 购物车不能为空 ");
            throw new SellException(ResultEnum.CART_IS_EMPTY);
        }
        OrderDTO creatResult = orderService.create(orderDTO);

        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("openid",creatResult.getBuyerOpenid());
        return ResultVOUtils.success(resultMap);
    }


//    订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】 openID为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<OrderDTO> orderDTOS = orderService.findList(openid, pageRequest);
        return ResultVOUtils.success(orderDTOS.getContent());
    }


//    订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){
//
//        OrderDTO one = orderService.findOne(orderId);
        OrderDTO orderOne = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtils.success(orderOne);
    }

//    取消订单
    @PostMapping("/cancle")
    public ResultVO cancle(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
        //
        buyerService.cancleOrder(openid, orderId);
        return ResultVOUtils.success();
    }



}