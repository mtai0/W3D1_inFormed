package org.revature.week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.revature.week3.pages.*;

public class Main {
    private static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        Level1Page l1 = PageFactory.initElements(driver, Level1Page.class);
        l1.correctInputs();

        Level2Page l2 = PageFactory.initElements(driver, Level2Page.class);
        l2.correctInputs();

        Level3Page l3 = PageFactory.initElements(driver, Level3Page.class);
        l3.correctInputs();

        Level4Page l4 = PageFactory.initElements(driver, Level4Page.class);
        l4.correctInputs();

        Level5Page l5 = PageFactory.initElements(driver, Level5Page.class);
        l5.correctInputs();

        Level6Page l6 = PageFactory.initElements(driver, Level6Page.class);
        l6.correctInputs();

        Level7Page l7 = PageFactory.initElements(driver, Level7Page.class);
        l7.correctInputs();

        Level8Page l8 = PageFactory.initElements(driver, Level8Page.class);
        l8.correctInputs();

        Level9Page l9 = PageFactory.initElements(driver, Level9Page.class);
        l9.correctInputs();

        Level10Page l10 = PageFactory.initElements(driver, Level10Page.class);
        l10.correctInputs();
    }
}