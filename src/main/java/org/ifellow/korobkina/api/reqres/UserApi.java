package org.ifellow.korobkina.api.reqres;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.ifellow.korobkina.dto.reqres.user.User;

import static io.restassured.RestAssured.given;

public class UserApi extends BaseReqresApi {
    private static final String USER_URN = "/api/users";

    @Step("Получение всех пользователей по URN")
    public ValidatableResponse getAllUser() {
        Allure.addAttachment("URN:", USER_URN);
        return given()
                .when()
                .get(USER_URN)
                .then();
    }

    @Step("Создание пользователя '{user}' по URN")
    public ValidatableResponse postUser(User user) {
        Allure.addAttachment("URN:", USER_URN);
        return given()
                .when()
                .body(user)
                .post(USER_URN)
                .then();
    }
}