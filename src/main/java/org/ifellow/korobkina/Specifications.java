package org.ifellow.korobkina;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specifications {

    public static RequestSpecification baseRequestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .log(LogDetail.BODY)
                .build();
    }

    public static RequestSpecification baseRequestSpecReqres(String url, String apiKey, String apiValue) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .addHeader(apiKey, apiValue)
                // .setKeyStore(apiKey, apiValue)
                .setContentType(ContentType.JSON)
                .log(LogDetail.BODY)
                .build();
    }
}
