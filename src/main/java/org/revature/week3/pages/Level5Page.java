package org.revature.week3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Level5Page {
    WebDriver driver;

    @FindBy(css="input[type='text']")
    WebElement inputField;

    @FindBy(xpath="//button[text()='Submit']")
    WebElement submitButton;

    @FindBy(xpath="//button[text()='Show Modal']")
    WebElement modalButton;

    @FindBy(xpath="//button[text()='Close']")
    WebElement closeButton;

    public Level5Page(WebDriver driver) {
        this.driver = driver;
        getPage();
    }

    public void getPage() {
        driver.get("http://127.0.0.1:5500/level-5.html");
    }

    public void correctInputs() {
        modalButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();

        StringBuilder toSubmit = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            inputField.sendKeys("a");
            driver.switchTo().alert().accept();
        }
        submitButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().alert().accept();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
