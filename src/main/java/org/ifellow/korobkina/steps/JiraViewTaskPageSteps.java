package org.ifellow.korobkina.steps;

import io.cucumber.java.ru.*;
import org.ifellow.korobkina.pages.JiraViewTaskPage;

public class JiraViewTaskPageSteps {
    private final JiraViewTaskPage jiraViewTaskPage = new JiraViewTaskPage();

    @И("^проверяем что статус задачи '(.*)'")
    public void checkStatus(String statusTaskDo) {
        jiraViewTaskPage.getStatusTask(statusTaskDo);
    }

    @И("^проверяем что версия задачи '(.*)'")
    public void checkVersion(String versionTask) {
        if (!versionTask.equals(jiraViewTaskPage.getVersionTask())) {
            System.out.println("Версия не Version 2.0");
        }
    }

    @Тогда("проводим баг по всем статусам")
    public void lifeCycleBug() {
        jiraViewTaskPage.lifeCycleBug();
    }

    @И("^проверяем что статус бага '(.*)'")
    public void checkStatusDone(String statusTaskDone) {
        jiraViewTaskPage.getStatusTask(statusTaskDone);
    }
}
