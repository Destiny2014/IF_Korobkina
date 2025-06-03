package org.ifellow.korobkina.reqres;

import org.aeonbits.owner.ConfigFactory;
import org.ifellow.korobkina.steps.reqres.UserSteps;
import org.ifellow.korobkina.dto.reqres.user.User;
import org.ifellow.korobkina.utils.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class reqresTest {
    private static final TestConfig config = ConfigFactory.create(TestConfig.class);
    private static final UserSteps userSteps = new UserSteps();

    @Test
    @DisplayName("Получение всех пользователей")
    public void chekGetAllUsersTest() {
        userSteps.getAllUsers();
    }

    @Test
    @DisplayName("Создание нового пользователя из файла")
    public void checkCreateUserFromFileTest() {
        User body = userSteps.createNewUserFromFile(config.new_name(), config.new_job());
        Assertions.assertEquals(config.new_name(), body.getName());
        Assertions.assertEquals(config.new_job(), body.getJob());
    }
}