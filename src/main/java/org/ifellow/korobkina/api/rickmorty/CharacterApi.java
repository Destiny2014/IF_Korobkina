package org.ifellow.korobkina.api.rickmorty;

import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CharacterApi extends BaseRickMortyApi {
    private static final String CHARACTER_URN = "/character";

    public ValidatableResponse getCharacterByNameId(String nameCharacter, int idCharacter) {
        return given()
                .queryParam("name", nameCharacter)
                .get(CHARACTER_URN + "/" + idCharacter)
                .then();
    }

    public ValidatableResponse getCharacterById(int id) {
        return given()
                .get(CHARACTER_URN + "/" + id)
                .then();
    }
}