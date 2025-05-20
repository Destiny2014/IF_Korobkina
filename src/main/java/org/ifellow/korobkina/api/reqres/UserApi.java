package org.ifellow.korobkina.api.reqres;

import io.restassured.response.ValidatableResponse;
import org.ifellow.korobkina.dto.user.User;

import static io.restassured.RestAssured.given;

public class UserApi extends BaseReqresApi {
    private static final String USER_URN = "/api/users";

    public ValidatableResponse getAllUser() {
        return given()
                .when()
                .get(USER_URN)
                .then();
    }

    public ValidatableResponse postUser(User user) {
        return given()
                .when()
                .body(user)
                .post(USER_URN)
                .then();
    }
}