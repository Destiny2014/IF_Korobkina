package org.ifellow.korobkina.api.rickmorty;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.aeonbits.owner.ConfigFactory;
import org.ifellow.korobkina.specifications.SpecificationsRickMorty;
import org.ifellow.korobkina.utils.TestConfig;

public abstract class BaseRickMortyApi {
    private static final TestConfig config = ConfigFactory.create(TestConfig.class);

    public BaseRickMortyApi() {
        RestAssured.requestSpecification = SpecificationsRickMorty.baseRequestSpec(config.rickmorty_url());
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.BODY)
                .build();
    }
}