package com.hzw.api.app.feign;

import com.hzw.api.app.feign.dto.SmsSendIDTO;
import com.hzw.api.app.feign.dto.SmsSendODTO;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: huangzuwang
 * @date: 2020-05-16 23:07
 * @description:
 */

@FeignClient(name = "third-party-center")
@RequestMapping("/sms")
public interface FeignSmsService {

    /**
     * 发送短信
     * @author: huangzuwang
     * @date: 2020-05-16 23:31
     * @param idto
     * @return
     **/
//    @LoadBalanced
    @RequestMapping("/send")
    SmsSendODTO send(@RequestBody SmsSendIDTO idto);
}
