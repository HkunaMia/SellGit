package com.imooc.sell.controller;

import com.imooc.sell.config.ProjectUrl;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @program: sell
 * @description:
 * @author: ma ru
 * @create: 2019-09-03 17:39
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {
    @Autowired
    private ProjectUrl projectUrl;

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxMpService wxOpenService;

    @GetMapping("/authorize")
    public  String authorize(@RequestParam("returnUrl") String returnUrl){
//        调用
        String url = projectUrl.getWechatMpAuthorize()+"/sell/wechat/userInfo";
        String redirectUrl = null;
        try {
            redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl, "utf-8"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        }catch (WxErrorException w){
            log.error("【微信网页授权】 {}",w);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(),w.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:" + returnUrl + "?openid=" + openId;
    }

    @GetMapping("/qrAuthorize")
    public String qrAutnorize(@RequestParam("returnUrl") String returnUrl){
       //String url = projectUrl.getWechatOpenAuthorize()+"/sell/wechat/qrUserInfo";
        String url = "http://sell.springboot.cn/sell/wechat/qrUserInfo";
        String redirectUrl = null;
        try {
            redirectUrl = wxOpenService.buildQrConnectUrl(url,WxConsts.QRCONNECT_SCOPE_SNSAPI_LOGIN,URLEncoder.encode(returnUrl,"utf-8"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/qrUserInfo")
    public  String qrUserInfo(@RequestParam("code") String code){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxOpenService.oauth2getAccessToken(code);
        }catch (WxErrorException w){
            log.error("【微信网页授权】 {}",w);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(),w.getError().getErrorMsg());
        }
        log.info("wxMpOAuth2AccessToken",wxMpOAuth2AccessToken);
        String openId = wxMpOAuth2AccessToken.getOpenId();

        return "?openid=" + openId;
    }
}