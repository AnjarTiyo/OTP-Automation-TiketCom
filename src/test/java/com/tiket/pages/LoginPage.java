package com.tiket.pages;

import org.openqa.selenium.By;

public class LoginPage {

    public static final String LOGIN_URL = "https://www.tiket.com/login";
    public static final By LOGIN_FIELD = By.name("username");
    public static final By LOGIN_BTN = By.cssSelector(".btn-custom");
    public static final By OTP_FIELD = By.name("otp");
}
