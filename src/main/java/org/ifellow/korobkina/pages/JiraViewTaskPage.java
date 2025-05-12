package org.ifellow.korobkina.pages;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class JiraViewTaskPage {
    private final SelenideElement statusTask = $x("//span[@id='status-val']").as("Статус задачи");
    private final SelenideElement versionTask = $x("//span[@id='fixVersions-field']").as("Версия задачи");
    private final SelenideElement buttonInProgress = $x("//a[@id='action_id_21']");
    private final SelenideElement buttonBusinessProc = $x("//a[@id='opsbar-transitions_more']");
    private final SelenideElement buttonDone = $x("//div[@class = 'command-bar']//span[text()='Выполнено']/..");

    public String getStatusTask(String status) {
        statusTask.shouldBe(visible, text(status));
        return (statusTask.getText());
    }

    public String getVersionTask() {
        versionTask.shouldBe(visible, Duration.ofSeconds(20));
        return (versionTask.getText());
    }

    public void lifeCycleBug() {
        buttonInProgress.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        buttonBusinessProc.shouldBe(visible, Duration.ofSeconds(40))
                .click();
        buttonDone.shouldBe(visible, Duration.ofSeconds(20))
                .click();
    }
}