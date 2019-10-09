package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.Period;

/**
 * @program: sell
 * @description: HTTP请求返回的最外层对象
 * @author: ma ru
 * @create: 2019-08-23 12:30
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
//要进行缓存的对象需要进行序列化，即继承serializable接口
public class ResultVO<T> implements Serializable{

    //生成唯一序列化ID的插件，快捷键Ctrl+shift+I
    private static final long serialVersionUID = 5286690861994412308L;

    //    错误码
    private Integer code;
//    提示信息
    private String message;
//    具体内容
    private T data;
}