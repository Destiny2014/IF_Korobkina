package org.ifellow.korobkina.api.rickmorty;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class CharacterApi extends BaseRickMortyApi {
    private static final String CHARACTER_URN = "/character";
    GeneralMethodsApi genMethod = new GeneralMethodsApi();

    @Step("Запрос на получение персонажа по имени: '{nameCharacter}' и id: '{idCharacter}' по URN")
    public ValidatableResponse getCharacterByNameId(String nameCharacter, int idCharacter) {
        return (genMethod.getSomething(nameCharacter, CHARACTER_URN, idCharacter));
    }

    @Step("Запрос на получение персонажа по id: '{id}' по URN ")
    public ValidatableResponse getCharacterById(int id) {
        return (genMethod.getSomething(CHARACTER_URN, id));
    }
}