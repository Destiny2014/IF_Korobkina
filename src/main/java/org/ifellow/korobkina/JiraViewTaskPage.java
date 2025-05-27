package org.ifellow.korobkina;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class JiraViewTaskPage {
    private final SelenideElement statusTask = $x("//span[@id='status-val']").as("Статус задачи");
    private final SelenideElement versionTask = $x("//span[@id='fixVersions-field']").as("Версия задачи");
    private final SelenideElement buttonInProgress = $x("//a[@id='action_id_21']").as("Кнопка В работе");
    private final SelenideElement buttonBusinessProc = $x("//a[@id='opsbar-transitions_more']").as("Кнопка Бизнес-процесс");
    private final SelenideElement buttonDone = $x("//div[@class = 'command-bar']//span[text()='Выполнено']/..").as("Кнопка Выполнено");

    @Step("Получение статуса задачи: '{status}'")
    public String getStatusTask(String status) {
        statusTask.shouldBe(visible, text(status));
        return (statusTask.getText());
    }

    @Step("Получение версии задачи TestSeleniumATHomework")
    public String getVersionTask() {
        versionTask.shouldBe(visible, Duration.ofSeconds(20));
        return (versionTask.getText());
    }

    @Step("Проведение бага по статусам до закрытого")
    public void lifeCycleBug() {
        buttonInProgress.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        buttonBusinessProc.shouldBe(visible, Duration.ofSeconds(40))
                .click();
        buttonDone.shouldBe(visible, Duration.ofSeconds(20))
                .click();
    }
}