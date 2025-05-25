package org.ifellow.korobkina.api.rickmorty;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class GeneralMethodsApi {

    public ValidatableResponse getSomething(String url, int id) {
        return given()
                .get(url + "/" + id)
                .then();
    }

    public ValidatableResponse getSomething(String str, String url, int id) {
        return given()
                .queryParam("name", str)
                .get(url + "/" + id)
                .then();
    }
}