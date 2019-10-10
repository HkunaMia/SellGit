package com.imooc.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-10-03 21:03
 */

@Data
@ConfigurationProperties(prefix = "progect-url")
@Component
public class ProjectUrl {

    public String wechatMpAuthorize;

    public String wechatOpenAuthorize;

    public String sell;
}