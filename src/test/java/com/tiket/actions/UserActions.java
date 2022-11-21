package com.tiket.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static net.serenitybdd.core.Serenity.getDriver;

public class UserActions {

    WebDriver driver = getDriver();

    public void inputTextTo(String text, By element) throws InterruptedException {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
        sleep(1000);
    }

    public void clickOn(By element){
        driver.findElement(element).click();
    }

    public void userWaitingURLIs(String URL){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(URL));
    }
}
