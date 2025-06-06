package org.ifellow.korobkina.api.rickmorty;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class EpisodeApi extends BaseRickMortyApi {
    private static final String EPISODE_URN = "/episode";
    GeneralMethodsApi genMethod = new GeneralMethodsApi();

    @Step("Запрос на получение последнего эпизода: '{lastEpisode}'")
    public ValidatableResponse getCharactersFromEpisode(int lastEpisode) {
        Allure.addAttachment("URN:", EPISODE_URN);
        return (genMethod.getSomething(EPISODE_URN, lastEpisode));
    }
}