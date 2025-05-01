package org.ifellow.korobkina;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class JiraProjectTestPage {
    private final SelenideElement hrefProjectTest = $x("//a[contains(@href,'/projects/TEST/summary') and text()='Test']").as("ссылка проекта Test");

    public String getHrefProjectTest() {
        return hrefProjectTest.getAttribute("href");
    }
}