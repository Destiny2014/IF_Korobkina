package org.ifellow.korobkina.rickmorty;

import io.restassured.path.json.JsonPath;
import org.ifellow.korobkina.steps.rickmorty.CharacterSteps;
import org.ifellow.korobkina.steps.rickmorty.EpisodeSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.ifellow.korobkina.utils.DataProperties.getProperty;

public class RickMortyTest {
    private static final CharacterSteps characterSteps = new CharacterSteps();
    private static final EpisodeSteps episodeSteps = new EpisodeSteps();
    JsonPath bodyMorty;
    JsonPath bodyEpisode;
    JsonPath bodyLastCharacter;

    @Test
    @DisplayName("Получение последнего эпизода у Морти Смита")
    public void checkGetCharacterTest() {
        bodyMorty = characterSteps.getCharacterByNameId(getProperty("name_Morty"), Integer.parseInt(getProperty("id_Morty")));
        Assertions.assertEquals(getProperty("name_Morty"), bodyMorty.get("name"));
        Assertions.assertEquals(getProperty("last_Episode"), episodeSteps.getLastEpisode(bodyMorty));
    }

    @Test
    @DisplayName("Получение последнего персонажа из последнего эпизода Морти Смита")
    public void checkGetLastCharacterTest() {
        checkGetCharacterTest();
        bodyEpisode = episodeSteps.getCharacterByEpisode(episodeSteps.getLastEpisode(bodyMorty));
        Assertions.assertEquals(getProperty("name_LastEpisode"), bodyEpisode.get("name"));
        Assertions.assertEquals(getProperty("last_Character"), characterSteps.getLastCharacter(bodyEpisode));
    }

    @Test
    @DisplayName("Получение местонахождения и рассы последнего персонажа")
    public void chekGetLocationSpeciesTest() {
        checkGetLastCharacterTest();
        bodyLastCharacter = characterSteps.getCharacterById(characterSteps.getLastCharacter(bodyEpisode));
        Assertions.assertEquals(getProperty("name_LastCharacter"), bodyLastCharacter.get("name"));
        Assertions.assertEquals(getProperty("location_LastCharacter"), bodyLastCharacter.get("location").toString());
        Assertions.assertEquals(getProperty("species_LastCharacter"), bodyLastCharacter.get("species"));
    }

    @Test
    @DisplayName("Проверка расы и местонахождения персонажей")
    public void chekLocationsSpeciesTest() {
        chekGetLocationSpeciesTest();
        Assertions.assertEquals(bodyMorty.get("species").toString(), bodyLastCharacter.get("species").toString());
        Assertions.assertNotEquals(bodyMorty.get("location").toString(), bodyLastCharacter.get("location").toString());
    }
}