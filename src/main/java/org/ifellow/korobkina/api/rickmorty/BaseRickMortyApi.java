package org.ifellow.korobkina.api.rickmorty;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.ifellow.korobkina.specifications.SpecificationsRickMorty;

import static org.ifellow.korobkina.utils.DataProperties.getProperty;

public abstract class BaseRickMortyApi {

    public BaseRickMortyApi() {
        RestAssured.requestSpecification = SpecificationsRickMorty.baseRequestSpec(getProperty("rickmorty_url"));
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}