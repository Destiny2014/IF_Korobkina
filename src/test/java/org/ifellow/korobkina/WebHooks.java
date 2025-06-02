package org.ifellow.korobkina;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import util.TestConfig;

@Slf4j
public class WebHooks {
    private static final TestConfig config = ConfigFactory.create(TestConfig.class);

    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(config.screenshots())
                .savePageSource(config.savePageSource()));
    }

    @Step("Открытие страницы JiraIFellow")
    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 15000;

        Selenide.open(config.url());
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.manage().window().maximize();

        new JiraLoginPage().authorization(config.userLogin(), config.userPassword());
    }

    @Step("Закрытие веб драйвера")
    @AfterEach
    public void afterTest() {
        Selenide.closeWebDriver();
    }
}