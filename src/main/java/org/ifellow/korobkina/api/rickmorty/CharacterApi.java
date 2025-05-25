package org.ifellow.korobkina.api.rickmorty;

import io.restassured.response.ValidatableResponse;

public class CharacterApi extends BaseRickMortyApi {
    private static final String CHARACTER_URN = "/character";
    GeneralMethodsApi genMethod = new GeneralMethodsApi();

    public ValidatableResponse getCharacterByNameId(String nameCharacter, int idCharacter) {
        return (genMethod.getSomething(nameCharacter, CHARACTER_URN, idCharacter));
    }

    public ValidatableResponse getCharacterById(int id) {
        return (genMethod.getSomething(CHARACTER_URN, id));
    }
}