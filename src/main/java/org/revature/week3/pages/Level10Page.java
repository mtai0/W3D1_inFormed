package org.revature.week3.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class Level10Page {
    WebDriver driver;

    @FindBy(css="input[type='file']")
    WebElement fileInput;

    @FindBy(xpath="//button[text()='Review']")
    WebElement submitButton;

    public Level10Page(WebDriver driver) {
        this.driver = driver;
        getPage();
    }

    public void getPage() {
        driver.get("http://127.0.0.1:5500/level-10.html");
    }

    public void correctInputs() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        File rawFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File toSend = new File("screenshot.png");
        try {
            FileUtils.copyFile(rawFile, toSend);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String absPath = toSend.getAbsolutePath();

        System.out.println(absPath);

        fileInput.sendKeys(absPath);
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.alertIsPresent());

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

        try {
            Files.deleteIfExists(Paths.get(absPath));
        } catch (IOException e) {
            System.out.println("File delete failed.");
            e.printStackTrace();
        }
    }
}
