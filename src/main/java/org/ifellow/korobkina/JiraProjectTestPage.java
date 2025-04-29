package org.ifellow.korobkina;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class JiraProjectTestPage {
    private final SelenideElement hrefProjectTest = $x("//a[contains(@href,'/projects/TEST/summary') and text()='Test']").as("ссылка проекта Test");
    private final SelenideElement buttonTask = $x("//span[contains(@class,'nav-item-label') and @title='Задачи']/parent::a").as("Кнопка Задачи в левом меню");

    public String getHrefProjectTest() {
        return hrefProjectTest.getAttribute("href");
    }
}
