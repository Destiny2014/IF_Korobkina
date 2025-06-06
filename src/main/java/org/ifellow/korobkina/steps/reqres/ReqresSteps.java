package org.ifellow.korobkina.steps.reqres;

import io.cucumber.java.ru.*;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.ifellow.korobkina.dto.reqres.user.User;
import org.ifellow.korobkina.utils.TestConfig;

@Slf4j
public class ReqresSteps {
    private static final TestConfig config = ConfigFactory.create(TestConfig.class);
    private static final UserSteps userSteps = new UserSteps();
    User body;

    @Step("Вызов метода получения всех пользователей")
    @Тогда("получили всех пользователей")
    public void getAllUsers() {
        userSteps.getAllUsers();
    }

    @Step("Вызов метода создания нового пользователя")
    @Тогда("создаем нового пользователя")
    public void createNewUser() {
        body = userSteps.createNewUserFromFile(config.new_name(), config.new_job());
    }

    @Step("Проверка что новое имя пользователя '{nameUser}'")
    @И("^проверяем что новое имя пользователя '(.*)'")
    public void checkNameUSer(String nameUser) {
        if (!nameUser.equals(body.getName())) {
            log.warn("Имя пользователя не Tomato");
        }
    }

    @Step("Проверка что название работы '{nameJob}'")
    @И("^проверяем что название работы '(.*)'")
    public void checkNameJob(String nameJob) {
        if (!nameJob.equals(body.getJob())) {
            log.warn("Название работы не Eat maket");
        }
    }
}
