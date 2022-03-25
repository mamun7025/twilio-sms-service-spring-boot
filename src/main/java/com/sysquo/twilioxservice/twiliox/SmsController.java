package com.sysquo.twilioxservice.twiliox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/v1/sms")
public class SmsController {

    private final Service service;


    @Autowired
    public SmsController(Service service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping
    public String sendSms(@RequestBody SmsRequest smsRequest){
        service.sendSms(smsRequest);
        return "SMS send";
    }

}
