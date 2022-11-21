package com.tiket.stepdefinitions;

import com.tiket.actions.UserActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.tiket.model.UserData.*;
import static com.tiket.pages.HomePage.*;
import static com.tiket.pages.LoginPage.*;
import static com.tiket.tasks.OTPHandling.getOTPNumber;
import static net.serenitybdd.core.Serenity.getDriver;

public class LoginWithOTPStepDef extends UserActions {

    WebDriver driver = getDriver();

    @Given("User already on Login Page")
    public void alreadyOnLoginPage() {
        driver.manage().window().maximize();
        driver.get(LOGIN_URL);
    }

    @When("User enter registered phone number")
    public void enterRegisteredPhoneNumber() throws InterruptedException {
        inputTextTo(REGISTERED_USER_PHONE_NUMBER, LOGIN_FIELD);
        clickOn(LOGIN_BTN);
    }

    @And("User input OTP")
    public void userInputOTP() throws InterruptedException {
        Thread.sleep(5000); //handle sms sent delay, for further improvement create wait smsBody not equals null
        inputTextTo(getOTPNumber(), OTP_FIELD);
    }

    @Then("User logged in")
    public void userLoggedIn() throws InterruptedException {
        userWaitingURLIs(HOME_PAGE_URL);
        Assertions.assertEquals(HOME_PAGE_URL, driver.getCurrentUrl());
        Thread.sleep(5000); //to show that user is logged in, you can delete it
        //TODO you can add assertions whether correct user logged in her by inspecting if correct name displayed and or other method
    }
}
