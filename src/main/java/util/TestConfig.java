package util;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:src/test/resources/auth.properties", "classpath:data.properties"})
public interface TestConfig extends Config {

    String url();

    @Key("userLogin")
    String userLogin();

    @Key("userPassword")
    String userPassword();

    @Key("screenshots")
    Boolean screenshots();

    @DefaultValue("savePageSource")
    Boolean savePageSource();

    @DefaultValue("taskName")
    String taskName();

    @DefaultValue("versionTask")
    String versionTask();

    @DefaultValue("nameNewBug")
    String nameNewBug();
}