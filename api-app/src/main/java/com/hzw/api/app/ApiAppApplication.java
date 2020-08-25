package com.hzw.api.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @EnableFeignClients 就像是一个开关，只有使用了该注解，OpenFeign相关的组件和配置机制才会生效.
 *  还可以对OpenFeign相关组件进行自定义配置
 * @author: huangzuwang
 * @date: 2020-05-16 23:28
 **/
@RibbonClients
@EnableFeignClients
@SpringBootApplication
public class ApiAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAppApplication.class, args);
    }

    //不用加【Ribbon单独使用时加】
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
