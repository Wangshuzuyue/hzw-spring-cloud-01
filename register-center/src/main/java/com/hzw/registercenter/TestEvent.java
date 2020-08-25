package com.hzw.registercenter;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.stereotype.Component;

/**
 * @author: huangzuwang
 * @date: 2020-08-05 17:13
 * @description: 监听eureka服务下线事件
 */
@Component
public class TestEvent {

    public void listen(EurekaInstanceCanceledEvent event){
        //发邮件，发短信
        System.out.println(">>>>>>>>>>>>>>>>>>服务下线！！！:" + event.getAppName() + " : " + event.getServerId());
    }
}
