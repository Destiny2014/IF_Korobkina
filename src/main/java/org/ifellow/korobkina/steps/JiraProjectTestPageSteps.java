package org.ifellow.korobkina.steps;

import io.cucumber.java.ru.*;
import org.ifellow.korobkina.pages.JiraProjectTestPage;

public class JiraProjectTestPageSteps {
    private final JiraProjectTestPage jiraProjectTest = new JiraProjectTestPage();

    @Тогда("^ссылка проекта Test '(.*)'")
    public void checkHRef(String hrefTest) {
        if (!hrefTest.equals(jiraProjectTest.getHrefProjectTest())) {
            System.out.println("Ссылки не равны");
        }
    }
}
