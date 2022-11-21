package com.tiket.tasks;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OTPHandlingWithJSoup {

    private static final String SMS_RECEIVE_FREE_URL = "https://sms24.me/en/countries/id";
    private static final String SMS_MESSAGE_LIST_URL = "https://sms24.me/en/countries/id";
    private static final String NUMBER_CSS_CLASS = "numbutton";
    private static final String TABLE_CSS_SELECTOR = "table.msgTable > tbody > tr";
    private static final String HREF = "href";
    private static final String HTML_TD = "td";
    private static final String FORWARD_SLASH = "/";
    private static final Pattern PATTERN = Pattern.compile("/info/(\\d+)/");


    public static String getMessage(final String phoneNumber, final String fromPhoneNumber) throws IOException {
        return Jsoup.connect(SMS_MESSAGE_LIST_URL)   //access the site
                .get()
                .body()                                                                        //get html body
                .select(TABLE_CSS_SELECTOR)
                .stream()
                .map(tr -> tr.getElementsByTag(HTML_TD))                                       //get all cells
                .filter(tds -> tds.get(0)
                        .text()
                        .trim()
                        .startsWith(fromPhoneNumber))                          //if the number starts with given number
                .findFirst()                                                                   //find first match
                .map(tds -> tds.get(2))                                                        //pick 3rd cell
                .map(td -> td.text().trim())                                                   //get cell value
                .orElseThrow(IllegalStateException::new);
    }
}
