package org.ifellow.korobkina.pages;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class JiraProjectTestTaskPage {
    private final SelenideElement h1AllTasks = $x("//h1/span[text()='Все задачи']").as("Заголовок Все задачи");
    private final SelenideElement switchFilter = $x("//button[@id='subnav-trigger']").as("Фильтр задач проекта");
    private final SelenideElement filterAllTasks = $x("//a[contains(@class,'dropdown2-radio') and text()='Все задачи']").as("Пункт Все задачи в фильтре");
    private final SelenideElement countTask = $x("//div[@class='showing']//descendant::span").as("Счетчик задач");
    private final SelenideElement buttonCreateTask = $x("//a[@id='create_link' and text()='Создать']").as("Кнопка создания задачи");
    private final SelenideElement inputSummary = $x("//input[@id='summary']").as("Поле ввода Тема");
    private final SelenideElement buttonCreateTaskEnd = $x("//input[@value='Создать']").as("Заключительная Кнопка Создать задачу ");
    private final SelenideElement inputSearch = $x("//input[@id='quickSearchInput']").as("Строка поиска в шапке");
    private final SelenideElement typeOfTask = $x("//div[contains(@class,'issuetype-ss')]/child::input").as("Меню выбора типа задачи");
    private final SelenideElement buttonTypeDescription = $x("//div[contains(@id, 'description-wiki')]//button[text()='Визуальный']").as("Кнопка Визуальный в описании");
    private final SelenideElement frameDescription = $x("//div[@field-id='description']//iframe").as("Фрейм описания");
    private final SelenideElement fieldDescription = $x("//body").as("Поле ввода Описание");
    private final SelenideElement selectCorrectVer = $x("//div[contains(@class,'versionspicker')]/label[contains(text(),'Исправить')]/following-sibling::select//option[@value='10000']").as("Версия 1.0");
    private final SelenideElement typeOfPriority = $x("//select[@id='priority']/preceding-sibling::div/input").as("Меню выбора типа приоритета");
    private final SelenideElement label = $x("//select[@id='labels']/preceding-sibling::div/textarea").as("Поле ввода метки");
    private final SelenideElement buttonTypeEnvironment = $x("//div[contains(@id, 'environment-wiki')]//button[text()='Визуальный']").as("Кнопка Визуальный в окружении");
    private final SelenideElement frameEnvironment = $x("//div[@field-id='environment']//iframe").as("Фрейм окружения");
    private final SelenideElement fieldEnvironment = $x("//body").as("Поле ввода Окружение");
    private final SelenideElement selectAffecttVer = $x("//div[contains(@class,'versionspicker')]/label[contains(text(),'Затронуты')]/following-sibling::select//option[@value='10000']").as("Версия 1.0");
    private final SelenideElement selectTieTasks = $x("//select[@id='issuelinks-linktype']").as("Связанные задачи");
    private final SelenideElement task = $x("//div[contains(@id,'issues-multi')]/textarea").as("Поле ввода связанное задачи");
    private final SelenideElement assigneToMe = $x("//button[@data-field-id='#assignee']").as("Кнопка Назначить меня");
    private final SelenideElement inputLinkEpic = $x("//div[contains(@id,'customfield_10100-single')]/input").as("Ссылка на эпик");
    private final SelenideElement inputSprint = $x("//div[contains(@id,'customfield_10104-single')]/input").as("Ссылка на эпик");
    private final SelenideElement selectCeverity = $x("//select[@id='customfield_10400']").as("Серьезность");
    private final SelenideElement message = $x("//div[contains(@class, 'closeable')]/a[contains(text(),'AT14')]");
    private final SelenideElement loading = $x("//div[@class='loading']");

    public String getH1AllTasks() {
        return h1AllTasks.getText();
    }

    public String getMessage() {
        String s = message.getText();
        String[] words = s.split(" ");
        return words[4];
    }

    public void createNewTaskFull(String nameNewBug) {
        buttonCreateTask.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        typeOfTask.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        typeOfTask.shouldBe(visible, Duration.ofSeconds(20))
                .val("Ошибка").pressEnter();
        inputSummary.shouldBe(visible, Duration.ofSeconds(20))
                .setValue(nameNewBug);
        buttonTypeDescription.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        switchTo().frame(frameDescription.shouldBe(visible, Duration.ofSeconds(20)));
        fieldDescription.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        fieldDescription.setValue("Описание бага");
        switchTo().defaultContent();
        selectCorrectVer.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        typeOfPriority.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        typeOfPriority.val("Low").pressEnter();
        label.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        label.setValue("AT14");
        buttonTypeEnvironment.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        switchTo().frame(frameEnvironment.shouldBe(visible, Duration.ofSeconds(20)));
        fieldEnvironment.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        fieldEnvironment.setValue("Окружение бага");
        switchTo().defaultContent();
        selectAffecttVer.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        selectTieTasks.shouldBe(visible, Duration.ofSeconds(20))
                .selectOptionByValue("clones");
        task.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        task.shouldBe(visible, Duration.ofSeconds(40))
                .setValue("TEST-181997").pressEnter();
        assigneToMe.shouldBe(visible, Duration.ofSeconds(30))
                .click();
        inputLinkEpic.shouldBe(visible, Duration.ofSeconds(40))
                .click();
        inputLinkEpic.shouldBe(visible, Duration.ofSeconds(20))
                .sendKeys(Keys.DOWN);
        inputLinkEpic.pressEnter();
        inputSprint.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        inputSprint.shouldBe(visible, Duration.ofSeconds(20))
                .setValue("Спринт 2").pressEnter();
        selectCeverity.shouldBe(visible, Duration.ofSeconds(20))
                .selectOptionByValue("10101");
        buttonCreateTaskEnd.shouldBe(visible, Duration.ofSeconds(20))
                .click();
    }

    public void openAllTasks() {
        switchFilter.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        filterAllTasks.shouldBe(visible, Duration.ofSeconds(40))
                .click();
    }

    public int getCountTasks() {
        loading.shouldNotBe(exist, Duration.ofSeconds(10));
        String countTasks = countTask.shouldBe(exist, Duration.ofSeconds(10))
                .getText();
        return (Integer.parseInt(splitCount(countTasks)));
    }

    private String splitCount(String countBefore) {
        String[] numbs = countBefore.split(" из ");
        return (numbs[1]);
    }

    public void createNewTaskLight(String nameTask) {
        buttonCreateTask.shouldBe(visible, Duration.ofSeconds(20))
                .click();
        inputSummary.shouldBe(visible, Duration.ofSeconds(20))
                .setValue(nameTask);
        buttonCreateTaskEnd.shouldBe(visible, Duration.ofSeconds(20))
                .click();
    }

    public void searchTask(String taskName) {
        inputSearch.shouldBe(visible, Duration.ofSeconds(20))
                .setValue(taskName).pressEnter();
    }
}