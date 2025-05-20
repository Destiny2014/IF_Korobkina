package org.ifellow.korobkina.api.reqres;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.ifellow.korobkina.specifications.SpecificationsReqres;

import static org.ifellow.korobkina.utils.DataProperties.getProperty;

public abstract class BaseReqresApi {

    public BaseReqresApi() {
        RestAssured.requestSpecification = SpecificationsReqres.baseRequestSpecReqres(getProperty("reqres_url"), getProperty("API_KEY"), getProperty("API_VALUE"));
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}