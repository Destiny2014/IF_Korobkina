package org.ifellow.korobkina.specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SpecificationsReqres {

    public static RequestSpecification baseRequestSpecReqres(String url, String apiKey, String apiValue) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .addHeader(apiKey, apiValue)
                .setContentType(ContentType.JSON)
                .log(LogDetail.BODY)
                .build();
    }
}