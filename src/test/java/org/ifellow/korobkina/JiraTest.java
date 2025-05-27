package org.ifellow.korobkina;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static util.DataProperties.getProperty;

@Epic(value = "Тестирование JiraIFellow")
public class JiraTest extends WebHooks {
    private final JiraDashPage jiraDashPage = new JiraDashPage();
    private final JiraProjectTestPage jiraProjectTest = new JiraProjectTestPage();
    private final JiraProjectTestTaskPage jiraProjectTestTask = new JiraProjectTestTaskPage();
    private final JiraViewTaskPage jiraViewTaskPage = new JiraViewTaskPage();

    private final String h1Dash = "System Dashboard";
    private final String hrefTest = "https://edujira.ifellow.ru/projects/TEST/summary";
    private final String statusTaskDo = "СДЕЛАТЬ";
    private final String nameNewBug = "New bug AT14";
    private final String statusTaskDone = "ГОТОВО";
    private final String nameNewTask = "New task for count task AT14";

    @Test
    @DisplayName("Авторизация в Jira")
    public void checkAuthorizationTest() {
        Assertions.assertEquals(h1Dash, jiraDashPage.getH1(), "Авторизация не пройдена");
    }

    @Test
    @DisplayName("Переход в проект Test")
    public void checkOpenProjectTest() {
        checkAuthorizationTest();
        jiraDashPage.openProject();
        Assertions.assertEquals(hrefTest, jiraProjectTest.getHrefProjectTest(), "Переход в проект Test не выполнен");
    }

    @Test
    @DisplayName("Общее кол-во задач в проекте")
    public void checkCountTaskTest() {
        checkOpenProjectTest();
        jiraProjectTestTask.openAllTasks();
        Assertions.assertEquals("Все задачи", jiraProjectTestTask.getH1AllTasks(), "Переход во все задачи проекта не выполнен");
        int countBefore = jiraProjectTestTask.getCountTasks();
        jiraProjectTestTask.createNewTaskLight(nameNewTask);
        jiraProjectTestTask.openAllTasks();
        Assertions.assertEquals("Все задачи", jiraProjectTestTask.getH1AllTasks(), "Переход во все задачи проекта не выполнен");
        int countAfter = jiraProjectTestTask.getCountTasks();
        Assertions.assertEquals(countAfter, countBefore + 1, "Кол-во задач не совпадает");
    }

    @Test
    @DisplayName("Проверка задачи TestSeleniumATHomework")
    public void checkStatusVersTaskTest() {
        checkCountTaskTest();
        jiraProjectTestTask.searchTask(getProperty("taskName"));
        Assertions.assertEquals(statusTaskDo, jiraViewTaskPage.getStatusTask(statusTaskDo), "Статус не СДЕЛАТЬ");
        Assertions.assertEquals(getProperty("versionTask"), jiraViewTaskPage.getVersionTask(), "Версия не Version 2.0");
    }

    @Test
    @DisplayName("Создание нового бага и проведение его по статусам")
    public void checkCreateBugTest() {
        checkStatusVersTaskTest();
        jiraProjectTestTask.createNewTaskFull(nameNewBug);
        Assertions.assertEquals(getProperty("userLogin"), jiraProjectTestTask.getMessage(), "Баг не создался");
        jiraProjectTestTask.searchTask(nameNewBug);
        jiraViewTaskPage.lifeCycleBug();
        Assertions.assertEquals(statusTaskDone, jiraViewTaskPage.getStatusTask(statusTaskDone));
    }
}