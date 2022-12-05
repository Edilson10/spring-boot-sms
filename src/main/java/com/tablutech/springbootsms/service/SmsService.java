package com.tablutech.springbootsms.service;

import com.tablutech.springbootsms.model.SmsTablu;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

    private final String ACCOUNT_SID ="AC6598cda1d0b350c70639d30a625af39f";

    private final String AUTH_TOKEN = "446e3f01bf61e9cbf981ed0c51e3d8f7";

    private final String FROM_NUMBER = "+258848444595";

    public void send(SmsTablu sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }
}
