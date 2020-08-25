package com.hzw.thirdpartycenter.controller;

import com.hzw.thirdpartycenter.dto.SmsSendIDTO;
import com.hzw.thirdpartycenter.dto.SmsSendODTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangzuwang
 * @date: 2020-05-16 22:48
 * @description:
 */
@Slf4j
@RequestMapping("/sms")
@RestController
public class SmsController {

    @RequestMapping("/send")
    public SmsSendODTO send(@RequestBody SmsSendIDTO idto){
        log.info("> > > > > > > > sms/send 收到请求:" + idto);
        SmsSendODTO odto = new SmsSendODTO();
        odto.setCode(10000);
        odto.setMsg("短信发送成功");
        return odto;
    }

    @RequestMapping("/testTransaction")
    public SmsSendODTO testTransaction(@RequestBody SmsSendIDTO idto){
        log.info("> > > > > > > > sms/testTransaction 收到请求:" + idto);
        SmsSendODTO odto = new SmsSendODTO();

        return odto;
    }

}
