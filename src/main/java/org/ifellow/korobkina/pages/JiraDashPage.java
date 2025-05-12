package org.ifellow.korobkina.pages;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class JiraDashPage {
    private final SelenideElement searchH1 = $x("//h1[contains(text(),'System')]").as("Заголовок страницы");
    private final SelenideElement buttonProject = $x("//a[text()='Проекты']").as("Кнопка Проекты в шапке");
    private final SelenideElement projectTest = $x("//a[contains(text(),'Test')]").as("Кнопка выбора проекта Test");

    public JiraDashPage getH1(String h1Dash) {
        searchH1.shouldHave(Condition.text(h1Dash));
        return this;
    }

    public void openProject() {
        buttonProject.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        projectTest.shouldBe(visible, Duration.ofSeconds(20))
                .click();
    }
}
