package com.hzw.api.app.feign.dto;

import lombok.Data;

/**
 * @author: huangzuwang
 * @date: 2020-05-16 22:50
 * @description:
 */
@Data
public class SmsSendIDTO {

    private String mobile;

    private String content;

}
