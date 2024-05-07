package org.revature.week3.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Level6Page {
    WebDriver driver;

    @FindBy(xpath="//button[text()='Submit']")
    WebElement submitButton;

    @FindBy(xpath="//h5[contains(text(), 'gate 1')]/a")
    WebElement link1;

    @FindBy(xpath="//h5[contains(text(), 'gate 2')]/a")
    WebElement link2;

    public Level6Page(WebDriver driver) {
        this.driver = driver;
        getPage();
    }

    public void getPage() {
        driver.get("http://127.0.0.1:5500/level-6a.html");
    }

    public void correctInputs() {
        DoLink(link1);
        DoLink(link2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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

    private void DoLink(WebElement link) {
        String linkDestination = link.getAttribute("href");
        String origWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(linkDestination);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button")));
        button.click();

        driver.close();
        driver.switchTo().window(origWindow);
    }

}
