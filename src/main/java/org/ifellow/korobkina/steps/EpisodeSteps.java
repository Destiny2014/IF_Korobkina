package org.ifellow.korobkina.steps;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.ifellow.korobkina.api.rickmorty.EpisodeApi;

import java.util.List;

public class EpisodeSteps {
    private static final EpisodeApi episodeApi = new EpisodeApi();
    private static final ParseStep parsString = new ParseStep();

    public String getLastEpisode(JsonPath body) {
        List<String> episodes = body.get("episode");
        return episodes.get(episodes.size() - 1);
    }

    public JsonPath getCharacterByEpisode(String lastEpisode) {
        int idEpisode = parsString.parseString(lastEpisode);
        return episodeApi.getCharactersFromEpisode(idEpisode)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
    }
}
