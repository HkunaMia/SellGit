package com.imooc.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-09-04 10:06
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    private String openAppId;

    private String openAppSecret;
//    商户号
    private String mchId;
//    商户秘钥
    private String mchKey;
//    商户证书秘钥
    private  String keyPath;

    private String notifyUrl;

}