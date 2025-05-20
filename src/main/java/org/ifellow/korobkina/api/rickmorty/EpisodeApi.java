package org.ifellow.korobkina.api.rickmorty;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class EpisodeApi extends BaseRickMortyApi {
    private static final String CHARACTER_URN = "/episode";

    public ValidatableResponse getCharactersFromEpisode(int lastEpisode) {
        return given()
                .when()
                .get(CHARACTER_URN + "/" + lastEpisode)
                .then();
    }
}
