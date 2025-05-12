package org.ifellow.korobkina.steps;

import io.cucumber.java.ru.*;
import org.ifellow.korobkina.pages.JiraProjectTestTaskPage;

public class JiraProjectTestTaskPageSteps {
    private final JiraProjectTestTaskPage jiraProjectTestTask = new JiraProjectTestTaskPage();
    private int countBefore;
    private int countAfter;

    @То("переходим во все задачи проекта")
    public void openAllTasks() {
        jiraProjectTestTask.openAllTasks();
    }

    @Если("^заголовок '(.*)'")
    public void checkH1AllTasks(String allTaskName) {
        if (!allTaskName.equals(jiraProjectTestTask.getH1AllTasks())) {
            System.out.println("Заголовки не равны");
        }
    }

    @То("получаем общее кол-во задач До")
    public int getCountBefore() {
        countBefore = jiraProjectTestTask.getCountTasks();
        return countBefore;
    }

    @И("^создаем новую задачу '(.*)'")
    public void createNewTask(String nameTask) {
        jiraProjectTestTask.createNewTaskLight(nameTask);
    }

    @То("получаем общее кол-во задач После")
    public void getCountAfter() {
        countAfter = jiraProjectTestTask.getCountTasks();
    }

    @И("проверяем на равенство кол-во задач до и после создания новой задачи")
    public void checkCountEquals() {
        if (countAfter != countBefore + 1) {
            System.out.println("Кол-во задач не совпадает");
        }
    }

    @Тогда("^ищем задачу '(.*)'")
    public void findTask(String taskName) {
        jiraProjectTestTask.searchTask(taskName);
    }

    @Тогда("^создаем полностью заполненный новый баг '(.*)'")
    public void createFullBug(String nameNewBug) {
        jiraProjectTestTask.createNewTaskFull(nameNewBug);
    }

    @И("^проверяем что плашка создания бага содержит '(.*)'")
    public void checkCreteBug(String partNameBug) {
        if (!partNameBug.equals(jiraProjectTestTask.getMessage())) {
            System.out.println("Баг не создался");
        }
    }

    @Также("^выполняем поиск созданного бага '(.*)'")
    public void searchNewBug(String nameNewBug) {
        jiraProjectTestTask.searchTask(nameNewBug);
    }
}

