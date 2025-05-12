package org.ifellow.korobkina.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.*;
import org.ifellow.korobkina.pages.JiraLoginPage;
//import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;

import static util.DataProperties.getProperty;

public class WebHooks {

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Тестирование началось");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("Тестирование завершилось");
    }

    @Before
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 15000;

        Selenide.open(getProperty("url"));
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.manage().window().maximize();

        new JiraLoginPage().authorization(getProperty("userLogin"), getProperty("userPassword"));
    }

    @After
    public void afterTest() {
        Selenide.closeWebDriver();
    }
}