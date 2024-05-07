package org.revature.week3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Level8Page {
    WebDriver driver;

    @FindBy(css="input[type='file']")
    WebElement fileInput;

    @FindBy(css="button")
    WebElement submitButton;

    public Level8Page(WebDriver driver) {
        this.driver = driver;
        getPage();
    }

    public void getPage() {
        driver.get("http://127.0.0.1:5500/level-8.html");
    }

    public void correctInputs() {
        File file = new File("gator.txt");
        String absPath = file.getAbsolutePath();

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Let's Go Gators");
            writer.close();
        } catch (IOException e) {
            System.out.println("Write failed.");
            e.printStackTrace();
        }

        fileInput.sendKeys(absPath);
        System.out.println(absPath);
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

        try {
            Files.deleteIfExists(Paths.get(absPath));
        } catch (IOException e) {
            System.out.println("File delete failed.");
            e.printStackTrace();
        }
    }
}
