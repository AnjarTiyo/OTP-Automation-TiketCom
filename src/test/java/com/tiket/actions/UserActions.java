package com.tiket.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
