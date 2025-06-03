package org.ifellow.korobkina.utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:src/test/resources/properties/reqres.properties", "classpath:properties/rickmorty.properties"})
public interface TestConfig extends Config {

    @Key("rickmorty_url")
    String rickmorty_url();

    @Key("name_Morty")
    String name_Morty();

    @Key("id_Morty")
    int id_Morty();

    @Key("last_Episode")
    String last_Episode();

    @Key("last_Character")
    String last_Character();

    @Key("name_LastEpisode")
    String name_LastEpisode();

    @Key("name_LastCharacter")
    String name_LastCharacter();

    @Key("location_LastCharacter")
    String location_LastCharacter();

    @Key("species_LastCharacter")
    String species_LastCharacter();

    @Key("reqres_url")
    String reqres_url();

    @Key("API_KEY")
    String API_KEY();

    @Key("API_VALUE")
    String API_VALUE();

    @Key("new_name")
    String new_name();

    @Key("new_job")
    String new_job();
}
