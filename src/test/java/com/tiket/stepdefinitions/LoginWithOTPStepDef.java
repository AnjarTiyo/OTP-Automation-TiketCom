package com.tiket.stepdefinitions;

import com.tiket.actions.UserActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.tiket.model.UserData.*;
import static com.tiket.pages.HomePage.*;
import static com.tiket.pages.LoginPage.*;
import static com.tiket.tasks.OTPHandling.getOTPNumber;
//import static net.serenitybdd.core.Serenity.getnewDriver();

public class LoginWithOTPStepDef extends UserActions {

//    WebDriver driver = getDriver();

    @Before
    public WebDriver newDriver() throws MalformedURLException {
        String url = "http://localhost:4444/wd/hub";
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        return new RemoteWebDriver(new URL(url), firefoxOptions);
    }

    @Given("User already on Login Page")
    public void alreadyOnLoginPage() throws MalformedURLException {
        newDriver().manage().window().maximize();
        newDriver().get(LOGIN_URL);
    }

    @When("User enter registered phone number")
    public void enterRegisteredPhoneNumber() throws InterruptedException {
        inputTextTo(REGISTERED_USER_PHONE_NUMBER, LOGIN_FIELD);
        clickOn(LOGIN_BTN);
    }

    @And("User input OTP")
    public void userInputOTP() throws InterruptedException {
        Thread.sleep(8000); //handle sms sent delay, for further improvement create wait smsBody not equals null
        inputTextTo(getOTPNumber(), OTP_FIELD);
    }

    @Then("User logged in")
    public void userLoggedIn() throws InterruptedException, MalformedURLException {
        userWaitingURLIs(HOME_PAGE_URL);
        Assertions.assertEquals(HOME_PAGE_URL, newDriver().getCurrentUrl());
        Thread.sleep(10000); //to show that user is logged in, you can delete it
        //TODO you can add assertions whether correct user logged in her by inspecting if correct name displayed and or other method
    }
}
