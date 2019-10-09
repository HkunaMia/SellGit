package com.imooc.sell.utils;

import com.imooc.sell.VO.ResultVO;

import java.util.Arrays;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-08-23 14:50
 */
public class ResultVOUtils {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        return resultVO;
    }
}