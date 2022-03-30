package com.mamun.twilioxservice.twiliox;

import com.mamun.twilioxservice.confiig.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.rest.notify.v1.service.Notification;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service("twilio")
public class TwilioSmsSender implements SmsSender{

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
        String message = smsRequest.getMessage();
        MessageCreator creator = Message.creator(to, from, message);
        creator.create();
    }

    @Override
    public void sendBulkSms(SmsRequest smsRequest) {

        List<String> toBindings = Arrays.asList(
                "{\"binding_type\":\"sms\",\"address\":\"+971521806054\"}",
                "{\"binding_type\":\"sms\",\"address\":\"+971589034689\"}");

        Notification notification = Notification
                .creator(twilioConfiguration.getNotifyServiceSid())
                .setBody("Hello Bob.. Test bulk message")
                .setToBinding(toBindings)
                .create();

        System.out.println(notification.getSid());

    }


}
