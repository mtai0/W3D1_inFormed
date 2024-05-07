package org.revature.week3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Level9Page {
    WebDriver driver;

    @FindBy(id="nameInput")
    WebElement nameInput;

    @FindBy(id="submitBtn")
    WebElement submitButton;

    public Level9Page(WebDriver driver) {
        this.driver = driver;
        getPage();
    }

    public void getPage() {
        driver.get("http://127.0.0.1:5500/level-9.html");
    }

    public void correctInputs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(nameInput)).sendKeys("Name");
        submitButton.click();

        //This page appears to lack a confirmation alert.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
