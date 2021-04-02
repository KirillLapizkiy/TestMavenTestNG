package ru.TestsProject;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    WebDriver wd = new FirefoxDriver();

    @BeforeClass
    public void setup() {
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://www.delivery-club.ru/");
        wd.manage().window().maximize();
    }

    @Test(priority = 1)
    @Description("Test-case-1")
    public void Test1() {
        String title = wd.getTitle();
        Assert.assertTrue(title.equals("Delivery Club — Доставка еды из ресторанов от 25 минут!"));
    }

    @Test(priority = 2)
    @Description("Test-case-2")
    public void Test2() {
        throw new SkipException("Skipping this Test");
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }
}
