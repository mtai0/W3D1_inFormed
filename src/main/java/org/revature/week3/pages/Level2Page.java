package org.revature.week3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class Level2Page {
    WebDriver driver;

    //@FindBy(id="userName")
    //@FindBy(css="input[id='userName']")
    //@FindBy(xpath = "/html/body/form/input[1]")
    //@FindBy(css="input#userName")

    @FindBy(name="input1")
    WebElement dropdown;

    @FindBy(name="checkbox1")
    WebElement checkBox1;

    @FindBy(name="checkbox2")
    WebElement checkBox2;

    @FindBy(name="checkbox3")
    WebElement checkBox3;

    @FindBy(css="input[type='date']")
    WebElement dateInput;

    @FindBy(css="button[type='submit']")
    WebElement correctButton;

    @FindBy(xpath="//dt[text()='Dropdown']/following-sibling::dd[1]")
    WebElement correctDropdownText;

    @FindBy(xpath="//dt[text()='Radio']/following-sibling::dd[1]")
    WebElement correctRadioText;

    @FindBy(xpath="//dt[text()='Date']/following-sibling::dd[1]")
    WebElement correctDateText;

    public Level2Page(WebDriver driver) {
        this.driver = driver;
        getPage();
    }

    public void getPage() {
        driver.get("http://127.0.0.1:5500/level-2.html");
    }

    //TODO: ACCOUNT FOR RANDOMIZATION
    public void correctInputs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        new Select(dropdown).selectByVisibleText(correctDropdownText.getText());

        if (!checkBox1.isSelected()) checkBox1.click();
        if (!checkBox2.isSelected()) checkBox2.click();
        if (!checkBox3.isSelected()) checkBox3.click();

        //TODO: Figure out how to make this FindBy
        driver.findElement(By.cssSelector("input[type='radio'][value='"+correctRadioText.getText()+"']")).click();

        String dateString = correctDateText.getText();

        String[] dateSplit = dateString.split("-");
        dateString = dateSplit[1] + "-" + dateSplit[2] + "-" + dateSplit[0];
        dateInput.sendKeys(dateString);

        correctButton.click();

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
