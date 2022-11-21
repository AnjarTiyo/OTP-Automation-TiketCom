package com.tiket.tasks;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import java.time.ZonedDateTime;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class OTPHandling {

    public static final String ACCOUNT_SID = "AC03194ad83714d956240116baef75ade4";
    public static final String AUTH_TOKEN = "c7e366fe6160afc93725247a5f4df5fd";

    public static final String TIKET_PHONE_NUMBER = "+16238888859";

    public static String getOTPNumber(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        String smsBody = getMessage();
        String smsBody = getOTP2();
//        System.out.println(smsBody);
//        String OTPNumber = smsBody.replaceAll("[^-?0-9]{4}", " ");
        String OTPNumber = smsBody.substring(102, 106);
//        String OTPNumber = filter.replaceAll("[OTP: ]", "");
//        System.out.println(OTPNumber);(^?<=OTP :)[0-9]{4}
        return OTPNumber;
    }

    public static String getMessage() {
        return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                .filter(m -> m.getTo().equals(TIKET_PHONE_NUMBER)).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages() {
        ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(), false);
    }

    public static String getOTP2(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String msg = null;
//         Untuk get semua mesasge
        ResourceSet<Message> messages = Message.reader()
                .setFrom(new com.twilio.type.PhoneNumber(TIKET_PHONE_NUMBER))
                .limit(1)
                .read();
        for(Message record : messages){
            msg = record.getBody();
        }
        return msg;
    }
}
