package com.tiket.tasks;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class OTPHandling {

    public static final String ACCOUNT_SID = "AC03194ad83714d956240116baef75ade4";
    public static final String AUTH_TOKEN = "b8c52cd9f14dc34ae34122d393d1657a";

    public static final String TIKET_PHONE_NUMBER = "+16238888859";

    public static String getOTPNumber(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String smsBody = getMessage();
        System.out.println(smsBody);
        String OTPNumber = smsBody.replaceAll("[^-?0-9]+", " ");
        System.out.println(OTPNumber);
        return OTPNumber;
    }

    public static String getMessage() {
        return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                .filter(m -> m.getTo().equals("+13343734019")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages() {
        ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(), false);
    }
}
