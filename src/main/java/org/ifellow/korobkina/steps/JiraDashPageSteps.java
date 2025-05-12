package org.ifellow.korobkina.steps;

import org.ifellow.korobkina.pages.JiraDashPage;
import io.cucumber.java.ru.*;

public class JiraDashPageSteps {
    private final JiraDashPage jiraDashPage = new JiraDashPage();

    @Тогда("^отобразился заголовок '(.*)'")
    public void displayH1(String h1Dash) {
        jiraDashPage.getH1(h1Dash);
    }

    @Тогда("перешли в проект Test")
    public void openProject() {
        jiraDashPage.openProject();
    }
}
