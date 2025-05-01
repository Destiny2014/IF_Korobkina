package org.ifellow.korobkina;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class JiraDashPage {
    private final SelenideElement searchH1 = $x("//h1[contains(text(),'System')]").as("Заголовок страницы");
    private final SelenideElement buttonProject = $x("//a[text()='Проекты']").as("Кнопка Проекты в шапке");
    private final SelenideElement projectTest = $x("//a[contains(text(),'Test')]").as("Кнопка выбора проекта Test");

    public String getH1() {
        return searchH1.getText();
    }

    public void openProject() {
        buttonProject.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        projectTest.shouldBe(visible, Duration.ofSeconds(20))
                .click();
    }
}
