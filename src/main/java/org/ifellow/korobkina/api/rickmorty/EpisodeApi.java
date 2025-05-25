package org.ifellow.korobkina.api.rickmorty;

import io.restassured.response.ValidatableResponse;

public class EpisodeApi extends BaseRickMortyApi {
    private static final String EPISODE_URN = "/episode";
    GeneralMethodsApi genMethod = new GeneralMethodsApi();

    public ValidatableResponse getCharactersFromEpisode(int lastEpisode) {
        return (genMethod.getSomething(EPISODE_URN, lastEpisode));
    }
}