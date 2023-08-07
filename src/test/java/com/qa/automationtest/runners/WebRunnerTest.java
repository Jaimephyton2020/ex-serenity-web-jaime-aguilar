package com.qa.automationtest.runners;

import com.qa.automationtest.util.*;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.runner.RunWith;

@Slf4j
@RunWith(CustomCucumberWithSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com.qa.automationtest.hooks", "com.qa.automationtest.glue"},
        plugin = "json:build/cucumber-reports/json/cucumber.json",
        tags = "@FlujoCompra"
)

public class WebRunnerTest {
    private static final EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    private WebRunnerTest() {
    }

    private static final String ALL_FEATURES = "todos";
    private static final String EXTENSION_FEATURE = ".feature";

}
