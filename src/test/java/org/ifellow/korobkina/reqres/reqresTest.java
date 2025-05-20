package org.ifellow.korobkina.reqres;

import org.ifellow.korobkina.steps.reqres.UserSteps;
import org.ifellow.korobkina.dto.reqres.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class reqresTest {
    private static final UserSteps userSteps = new UserSteps();
    String newName = "Tomato";
    String newJob = "Eat maket";

    @Test
    @DisplayName("Получение всех пользователей")
    public void chekGetAllUsersTest() {
        userSteps.getAllUsers();
    }

    @Test
    @DisplayName("Создание нового пользователя из файла")
    public void checkCreateUserFromFileTest() {
        User body = userSteps.createNewUserFromFile(newName, newJob);
        Assertions.assertEquals(newName, body.getName());
        Assertions.assertEquals(newJob, body.getJob());
    }
}