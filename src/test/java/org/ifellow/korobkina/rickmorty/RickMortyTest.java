package org.ifellow.korobkina.rickmorty;

import io.restassured.path.json.JsonPath;
import org.aeonbits.owner.ConfigFactory;
import org.ifellow.korobkina.steps.rickmorty.CharacterSteps;
import org.ifellow.korobkina.steps.rickmorty.EpisodeSteps;
import org.ifellow.korobkina.utils.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RickMortyTest {
    private static final TestConfig config = ConfigFactory.create(TestConfig.class);
    private static final CharacterSteps characterSteps = new CharacterSteps();
    private static final EpisodeSteps episodeSteps = new EpisodeSteps();
    JsonPath bodyMorty;
    JsonPath bodyEpisode;
    JsonPath bodyLastCharacter;

    @Test
    @DisplayName("Получение последнего эпизода у Морти Смита")
    public void checkGetCharacterTest() {
        bodyMorty = characterSteps.getCharacterByNameId(config.name_Morty(), config.id_Morty());
        Assertions.assertEquals(config.name_Morty(), bodyMorty.get("name"), "Имя персонажа не Morty Smith");
        Assertions.assertEquals(config.last_Episode(), episodeSteps.getLastEpisode(bodyMorty), "Последний эпизод не https://rickandmortyapi.com/api/episode/51");
    }

    @Test
    @DisplayName("Получение последнего персонажа из последнего эпизода Морти Смита")
    public void checkGetLastCharacterTest() {
        checkGetCharacterTest();
        bodyEpisode = episodeSteps.getCharacterByEpisode(episodeSteps.getLastEpisode(bodyMorty));
        Assertions.assertEquals(config.name_LastEpisode(), bodyEpisode.get("name"), "Имя последнего эпизода не Rickmurai Jack");
        Assertions.assertEquals(config.last_Character(), characterSteps.getLastCharacter(bodyEpisode), "Последний персонаж не https://rickandmortyapi.com/api/character/825");
    }

    @Test
    @DisplayName("Получение местонахождения и рассы последнего персонажа")
    public void chekGetLocationSpeciesTest() {
        checkGetLastCharacterTest();
        bodyLastCharacter = characterSteps.getCharacterById(characterSteps.getLastCharacter(bodyEpisode));
        Assertions.assertEquals(config.name_LastCharacter(), bodyLastCharacter.get("name"), "Имя последнего персонажа не Young Jerry");
        Assertions.assertEquals(config.location_LastCharacter(), bodyLastCharacter.get("location").toString(), "Локация последнего персонажа не {name=Earth (Unknown dimension), url=https://rickandmortyapi.com/api/location/30}");
        Assertions.assertEquals(config.species_LastCharacter(), bodyLastCharacter.get("species"), "Последний персонаж не Human");
    }

    @Test
    @DisplayName("Проверка расы и местонахождения персонажей")
    public void chekLocationsSpeciesTest() {
        chekGetLocationSpeciesTest();
        Assertions.assertEquals(bodyMorty.get("species").toString(), bodyLastCharacter.get("species").toString(), "Один из персонажей не Human");
        Assertions.assertNotEquals(bodyMorty.get("location").toString(), bodyLastCharacter.get("location").toString(), "Персонажи находятся в одной локакции");
    }
}