package org.ifellow.korobkina.api.rickmorty;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.ifellow.korobkina.Specifications;

import static org.ifellow.korobkina.util.DataProperties.getProperty;

public abstract class BaseRickMortyApi {

    public BaseRickMortyApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(getProperty("rickmorty_url"));
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}