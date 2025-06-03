package org.ifellow.korobkina;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.*;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/feature")//feature location
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")//красивый вид логов
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.ifellow.korobkina")

public class CucumberRunnerTest {
}
