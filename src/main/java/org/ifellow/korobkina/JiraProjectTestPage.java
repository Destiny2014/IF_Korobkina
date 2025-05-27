package org.ifellow.korobkina;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class JiraProjectTestPage {
    private final SelenideElement hrefProjectTest = $x("//a[contains(@href,'/projects/TEST/summary') and text()='Test']").as("ссылка проекта Test");

    @Step("Получение ссылки проекта Test")
    public String getHrefProjectTest() {
        Allure.addAttachment("Ссылка проекта Test:", hrefProjectTest.getAttribute("href"));
        return hrefProjectTest.getAttribute("href");
    }
}