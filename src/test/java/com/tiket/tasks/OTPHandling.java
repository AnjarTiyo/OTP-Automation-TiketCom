package com.tiket.tasks;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

/*  Twilio Fetch OTP Handling
 *
 *  Author   : Anjar Tiyo
 *  Github   : github.com/AnjarTiyo
 *
 */

public class OTPHandling {

    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID"); 
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static final String TIKET_PHONE_NUMBER = "+16238888859";

    public static String getOTPNumber() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String smsBody = getSmsBody();
        String OTPNumber = smsBody.substring(102, 106);
        return OTPNumber;
    }

    public static String getSmsBody() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String msg = null;
        ResourceSet<Message> messages = Message.reader()
                .setFrom(new com.twilio.type.PhoneNumber(TIKET_PHONE_NUMBER))
                .limit(1) //fetch latest message, for more reliable code, improve with filter
                .read();
        for (Message record : messages) {
            msg = record.getBody();
        }
        return msg;
    }
}
