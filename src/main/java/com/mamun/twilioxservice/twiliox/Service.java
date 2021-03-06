package com.mamun.twilioxservice.twiliox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class Service {

    private final SmsSender smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest){
        this.smsSender.sendSms(smsRequest);
    }

    public void sendBulkSms(SmsRequest smsRequest){
        this.smsSender.sendBulkSms(smsRequest);
    }

}
