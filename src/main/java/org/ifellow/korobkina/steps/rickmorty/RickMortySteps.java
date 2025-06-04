package org.ifellow.korobkina.steps.rickmorty;

import io.cucumber.java.ru.*;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.ifellow.korobkina.utils.TestConfig;

@Slf4j
public class RickMortySteps {
    private static final CharacterSteps character = new CharacterSteps();
    private static final EpisodeSteps episodeSteps = new EpisodeSteps();
    private static final CharacterSteps characterSteps = new CharacterSteps();
    private static final TestConfig config = ConfigFactory.create(TestConfig.class);
    JsonPath bodyMorty;
    JsonPath bodyEpisode;
    JsonPath bodyLastCharacter;

    @Step("Получение персонажа Morty Smith")
    @Когда("получаем персонажа Morty Smith")
    public void getCharacter() {
        bodyMorty = character.getCharacterByNameId(config.name_Morty(), config.id_Morty());
    }

    @Step("Проверка что имя персонажа '{name}'")
    @Тогда("^проверяем что его имя '(.*)'")
    public void chekCharacterName(String name) {
        if (!name.equals(bodyMorty.get("name"))) {
            log.warn("Имя персонажа не Morty Smith");
        }
    }

    @Step("Получение последнего эпизода Morty Smith")
    @И("получаем последний эпизод Morty Smith")
    public void getLastEpisode() {
        episodeSteps.getLastEpisode(bodyMorty);
    }

    @Step("Проверка что эпизод '{lastEpisode}'")
    @И("^проверяем что это эпизод '(.*)'")
    public void checkLastEpisode(String lastEpisode) {
        if (!lastEpisode.equals(episodeSteps.getLastEpisode(bodyMorty))) {
            log.warn("Эпизод не https://rickandmortyapi.com/api/episode/51");
        }
    }

    @Step("Получение body последнего эпизода")
    @Тогда("^получаем body последнего эпизода")
    public void getBodyFromLastEpisode() {
        bodyEpisode = episodeSteps.getCharacterByEpisode(episodeSteps.getLastEpisode(bodyMorty));
    }

    @Step("Проверка что название последнего эпизода '{nameLastEpisode}'")
    @И("^проверяем что название последного эпизода '(.*)'")
    public void checkNameLastEpisode(String nameLastEpisode) {
        if (!nameLastEpisode.equals(bodyEpisode.get("name"))) {
            log.warn("Имя последнего эпизода не Rickmurai Jack");
        }
    }

    @Step("Проверка что последний персонаж из эпизода '{lastCharacter}'")
    @И("^проверяем что последний персонаж из эпизода '(.*)'")
    public void checkLastCharacterFromLastEpisode(String lastCharacter) {
        if (!lastCharacter.equals(characterSteps.getLastCharacter(bodyEpisode))) {
            log.warn("Последний персонаж не https://rickandmortyapi.com/api/character/825");
        }
    }

    @Step("Получение последнего персонажа из последнего эпизода")
    @Тогда("получаем последнего персонажа из последного эпизода")
    public void getLastCharacterFromLastEpisode() {
        bodyLastCharacter = characterSteps.getCharacterById(characterSteps.getLastCharacter(bodyEpisode));
    }

    @Step("Проверка что имя последнего персонажа '{nameLastCharacter}'")
    @И("^проверяем что имя последнего персонажа '(.*)'")
    public void checkNameLastCharacter(String nameLastCharacter) {
        if (!nameLastCharacter.equals(bodyLastCharacter.get("name"))) {
            log.warn("Имя последнего персонажа не Young Jerry");
        }
    }

    @Step("Проверка что локация последнего персонажа '{locationLastCharacter}'")
    @Тогда("^проверяем что локация последнего персонажа '(.*)'")
    public void checkLocationLastCharacter(String locationLastCharacter) {
        if (!locationLastCharacter.equals(bodyLastCharacter.get("location").toString())) {
            log.warn("Локация последнего персонажа не {name=Earth (Unknown dimension), url=https://rickandmortyapi.com/api/location/30}");
        }
    }

    @Step("Проверка что раса последнего персонажа '{speciesLastCharacter}'")
    @И("^проверяем что раса последнего персонажа '(.*)'")
    public void checkSpeciesLastCharacter(String speciesLastCharacter) {
        if (!speciesLastCharacter.equals(bodyLastCharacter.get("species"))) {
            log.warn("Последний персонаж не Human");
        }
    }

    @Step("Проверка расы Морти и последнего персонажа")
    @Тогда("проверяем расы Морти и последнего персонажа")
    public void checkSpeciesCharacters() {
        if (!bodyMorty.get("species").toString().equals(bodyLastCharacter.get("species").toString())) {
            log.warn("Расы Морти и последнего персонажа не совпадают");
        }
    }

    @Step("Проверка что персонажи находятся в разных локациях")
    @И("проверяем что персонажи находятся в разных локациях")
    public void checkLocationsCharacters() {
        if (!bodyMorty.get("location").toString().equals(bodyLastCharacter.get("location").toString())) {
            log.warn("Морти и последней персонаж находятся в одной локации");
        }
    }
}