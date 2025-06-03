package org.ifellow.korobkina.api.reqres;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.aeonbits.owner.ConfigFactory;
import org.ifellow.korobkina.specifications.SpecificationsReqres;
import org.ifellow.korobkina.utils.TestConfig;

public abstract class BaseReqresApi {
    private static final TestConfig config = ConfigFactory.create(TestConfig.class);

    public BaseReqresApi() {
        RestAssured.requestSpecification = SpecificationsReqres.baseRequestSpecReqres(config.reqres_url(), config.API_KEY(), config.API_VALUE());
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.BODY)
                .build();
    }
}