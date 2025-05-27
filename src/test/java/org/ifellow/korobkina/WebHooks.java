package org.ifellow.korobkina;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;

import static util.DataProperties.getProperty;

public class WebHooks {

    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Step("Открытие страницы JiraIFellow")
    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 15000;

        Selenide.open(getProperty("url"));
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.manage().window().maximize();

        new JiraLoginPage().authorization(getProperty("userLogin"), getProperty("userPassword"));
    }

    @Step("Закрытие веб драйвера")
    @AfterEach
    public void afterTest() {
        Selenide.closeWebDriver();
    }
}