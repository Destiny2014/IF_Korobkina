package org.ifellow.korobkina;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import java.time.Duration;

public class JiraDashPage {
    private final SelenideElement searchH1 = $x("//h1[contains(text(),'System')]").as("Заголовок страницы");
    private final SelenideElement buttonProject = $x("//a[text()='Проекты']").as("Кнопка Проекты в шапке");
    private final SelenideElement projectTest = $x("//a[contains(text(),'Test')]").as("Кнопка выбора проекта Test");

    @Step("Получение заголовка страницы System Dashboard")
    public String getH1() {
        Allure.addAttachment("Заголовок страницы:", searchH1.getText());
        return searchH1.getText();
    }

    @Step("Переход в проект Test через клик в меню Проекты -> Test")
    public void openProject() {
        buttonProject.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        projectTest.shouldBe(visible, Duration.ofSeconds(20))
                .click();
    }
}