package org.ifellow.korobkina.api.rickmorty;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class GeneralMethodsApi {

    @Step("Получение ответа от API по url: '{url}' и id: '{id}'")
    public ValidatableResponse getSomething(String url, int id) {
        return given()
                .get(url + "/" + id)
                .then();
    }

    @Step("Получение ответа от API по значению в виде строки: '{str}', url: '{url}' и id: '{id}'")
    public ValidatableResponse getSomething(String str, String url, int id) {
        return given()
                .queryParam("name", str)
                .get(url + "/" + id)
                .then();
    }
}