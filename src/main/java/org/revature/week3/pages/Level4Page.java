package org.revature.week3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Level4Page {
    WebDriver driver;

    @FindBy(css="input[type='text']")
    WebElement inputField;

    @FindBy(css="button")
    WebElement submitButton;

    public Level4Page(WebDriver driver) {
        this.driver = driver;
        getPage();
    }

    public void getPage() {
        driver.get("http://127.0.0.1:5500/level-4.html");
    }

    public void correctInputs() {
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
