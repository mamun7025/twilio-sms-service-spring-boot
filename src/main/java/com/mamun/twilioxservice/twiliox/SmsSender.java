package com.mamun.twilioxservice.twiliox;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest);
    void sendBulkSms(SmsRequest smsRequest);

}
