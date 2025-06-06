package org.ifellow.korobkina.specifications;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SpecificationsReqres {

    @Step("Получение доступа к API по URL:'{url}', API Key и API Value")
    public static RequestSpecification baseRequestSpecReqres(String url, @Param(mode = Parameter.Mode.HIDDEN) String apiKey, @Param(mode = Parameter.Mode.HIDDEN) String apiValue) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .addHeader(apiKey, apiValue)
                .setContentType(ContentType.JSON)
                .log(LogDetail.BODY)
                .build();
    }
}