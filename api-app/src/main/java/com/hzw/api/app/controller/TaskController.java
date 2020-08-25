package com.hzw.api.app.controller;

import com.hzw.api.app.dto.TaskReceiveIDTO;
import com.hzw.api.app.dto.TaskReceiveODTO;
import com.hzw.api.app.feign.FeignSmsService;
import com.hzw.api.app.feign.dto.SmsSendIDTO;
import com.hzw.api.app.feign.dto.SmsSendODTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangzuwang
 * @date: 2020-05-16 22:48
 * @description:
 */
@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @Autowired
    private FeignSmsService feignSmsService;

    @RequestMapping("/receive")
    public TaskReceiveODTO receive(@RequestBody TaskReceiveIDTO idto){
        log.info("> > > > > > > > task/receive 任务抢单 收到请求:" + idto);
        SmsSendIDTO smsSendIDTO = new SmsSendIDTO();
        smsSendIDTO.setMobile("16619726811");
        smsSendIDTO.setContent("您已成功抢单");
        SmsSendODTO send = feignSmsService.send(smsSendIDTO);
        log.info("> > > > > > > > task/receive feign调用发送短信 收到响应:" + send);
        TaskReceiveODTO odto = new TaskReceiveODTO();
        odto.setCode(100);
        odto.setMsg("抢单成功");
        return odto;
    }

}
