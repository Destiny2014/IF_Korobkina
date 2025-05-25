package org.ifellow.korobkina.reqres;

import org.ifellow.korobkina.steps.reqres.UserSteps;
import org.ifellow.korobkina.dto.reqres.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.ifellow.korobkina.utils.DataProperties.getProperty;


public class reqresTest {
    private static final UserSteps userSteps = new UserSteps();

    @Test
    @DisplayName("Получение всех пользователей")
    public void chekGetAllUsersTest() {
        userSteps.getAllUsers();
    }

    @Test
    @DisplayName("Создание нового пользователя из файла")
    public void checkCreateUserFromFileTest() {
        User body = userSteps.createNewUserFromFile(getProperty("new_name"), getProperty("new_job"));
        Assertions.assertEquals(getProperty("new_name"), body.getName());
        Assertions.assertEquals(getProperty("new_job"), body.getJob());
    }
}