package org.revature.week3.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Level7Page {
    WebDriver driver;

    @FindBy(xpath="//button[contains(text(), 'smaller')]")
    WebElement smallButton;

    @FindBy(xpath="//button[contains(text(), 'larger')]")
    WebElement largeButton;

    @FindBy(xpath="//button[contains(text(), 'Submit')]")
    WebElement submitButton;

    public Level7Page(WebDriver driver) {
        this.driver = driver;
        getPage();
    }

    public void getPage() {
        driver.get("http://127.0.0.1:5500/level-7.html");
    }

    public void correctInputs() {
        Dimension origSize = driver.manage().window().getSize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().setSize(new Dimension(1, 1));
        wait.until(ExpectedConditions.elementToBeClickable(smallButton)).click();

        driver.manage().window().setSize(new Dimension(1000, 1000));
        wait.until(ExpectedConditions.elementToBeClickable(largeButton)).click();

        driver.manage().window().setSize(origSize);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

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
