package org.ifellow.korobkina.rickmorty;

import io.restassured.path.json.JsonPath;
import org.ifellow.korobkina.steps.rickmorty.CharacterSteps;
import org.ifellow.korobkina.steps.rickmorty.EpisodeSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RickMortyTest {
    private static final CharacterSteps characterSteps = new CharacterSteps();
    private static final EpisodeSteps episodeSteps = new EpisodeSteps();
    String nameMorty = "Morty Smith";
    int idMorty = 2;
    String lastEpisode = "https://rickandmortyapi.com/api/episode/51";
    String lastCharacter = "https://rickandmortyapi.com/api/character/825";
    JsonPath bodyMorty;
    JsonPath bodyEpisode;
    JsonPath bodyLastCharacter;
    String nameLastEpisode = "Rickmurai Jack";
    String nameLastCharacter = "Young Jerry";
    String locationLastCharacter = "{name=Earth (Unknown dimension), url=https://rickandmortyapi.com/api/location/30}";
    String speciesLastCharacter = "Human";

    @Test
    @DisplayName("Получение последнего эпизода у Морти Смита")
    public void checkGetCharacterTest() {
        bodyMorty = characterSteps.getCharacterByName(nameMorty, idMorty);
        Assertions.assertEquals(nameMorty, bodyMorty.get("name"));
        Assertions.assertEquals(lastEpisode, episodeSteps.getLastEpisode(bodyMorty));
    }

    @Test
    @DisplayName("Получение последнего персонажа из последнего эпизода Морти Смита")
    public void checkGetLastCharacterTest() {
        checkGetCharacterTest();
        bodyEpisode = episodeSteps.getCharacterByEpisode(episodeSteps.getLastEpisode(bodyMorty));
        Assertions.assertEquals(nameLastEpisode, bodyEpisode.get("name"));
        Assertions.assertEquals(lastCharacter, characterSteps.getLastCharacter(bodyEpisode));
    }

    @Test
    @DisplayName("Получение местонахождения и рассы последнего персонажа")
    public void chekGetLocationSpeciesTest() {
        checkGetLastCharacterTest();
        bodyLastCharacter = characterSteps.getCharacterById(characterSteps.getLastCharacter(bodyEpisode));
        Assertions.assertEquals(nameLastCharacter, bodyLastCharacter.get("name"));
        Assertions.assertEquals(locationLastCharacter, bodyLastCharacter.get("location").toString());
        Assertions.assertEquals(speciesLastCharacter, bodyLastCharacter.get("species"));
    }

    @Test
    @DisplayName("Проверка расы и местонахождения персонажей")
    public void chekLocationsSpeciesTest() {
        chekGetLocationSpeciesTest();
        Assertions.assertEquals(bodyMorty.get("species").toString(), bodyLastCharacter.get("species").toString());
        Assertions.assertNotEquals(bodyMorty.get("location").toString(), bodyLastCharacter.get("location").toString());
    }
}