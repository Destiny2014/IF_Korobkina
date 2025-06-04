package org.ifellow.korobkina.steps.rickmorty;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.ifellow.korobkina.api.rickmorty.CharacterApi;
import java.util.List;

public class CharacterSteps {
    private static final CharacterApi characterApi = new CharacterApi();
    private static final ParseStep parsString = new ParseStep();

    @Step("Получение персонажа по имени '{name}' и id '{id}'")
    public JsonPath getCharacterByNameId(String name, int id) {
        return characterApi.getCharacterByNameId(name, id)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
    }

    @Step("Получение последнего персонажа")
    public String getLastCharacter(JsonPath body) {
        List<String> characters = body.get("characters");
        return characters.get(characters.size() - 1);
    }

    @Step("Получение персонажа по id")
    public JsonPath getCharacterById(String lastCharacter) {
        int idPers = parsString.parseString(lastCharacter);
        return characterApi.getCharacterById(idPers)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
    }
}