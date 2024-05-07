package org.revature.week3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Level1Page {
    WebDriver driver;

    @FindBy(id="nameInput")
    WebElement inputField;

    @FindBy(id="randomString")
    WebElement randomString;

    public Level1Page(WebDriver driver) {
        this.driver = driver;
        getPage();
    }

    public void getPage() {
        driver.get("http://127.0.0.1:5500/level-1.html");
    }

    public void submitInput(String input) {
        inputField.sendKeys(input);
        inputField.submit();
    }

    public void correctInputs() {
        String str = randomString.getText();
        inputField.sendKeys(str);
        inputField.submit();

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
