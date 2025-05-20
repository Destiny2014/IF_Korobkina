package org.ifellow.korobkina.reqres;

import io.restassured.path.json.JsonPath;
import org.ifellow.korobkina.api.reqres.UserSteps;
import org.ifellow.korobkina.dto.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class reqresTest {
    private static final UserSteps userSteps = new UserSteps();
    String newName = "Tomato";
    String newJob = "Eat maket";

    @Test
    @DisplayName("Получение всех пользователей")
    public void chekGetAllUsers() {
        JsonPath body = userSteps.getAllUsers();
    }

   /* @Test
    @DisplayName("Создание нового пользователя")
    public void checkCreateUser(){
        JsonPath body = userSteps.createNewUser(newName, newJob);
        Assertions.assertEquals(newName, body.get("name"));
        Assertions.assertEquals(newJob, body.get("job"));
    }*/

    @Test
    @DisplayName("Создание нового пользователя из файла")
    public void checkCreateUserFromFile() {
        User body = userSteps.createNewUserFromFile(newName, newJob);
        Assertions.assertEquals(newName, body.getName());
        Assertions.assertEquals(newJob, body.getJob());
    }
}
