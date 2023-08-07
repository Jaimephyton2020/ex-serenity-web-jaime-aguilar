package com.qa.automationtest.runners;

import com.qa.automationtest.util.*;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

    @BeforeSuite
    public static void init() throws IOException {
        ControlsExecutionParallelAgents.featuresSegmentation();

        String featureName = variables.getProperty("featureName");
        List<String> features = FeatureOverwrite.listFilesByFolder(featureName, new File(PathConstants.featurePath()));
        for (String feature : features) {
            if (feature.contains(EXTENSION_FEATURE)) {
                FeatureOverwrite.overwriteFeatureFileAdd(feature);
            }
        }
        FeatureOverwrite.clearListFilesByFolder();
    }


    @AfterSuite
    public static void after() throws IOException {
        String featureName = variables.getProperty("featureName");
        List<String> features = FeatureOverwrite.listFilesByFolder(featureName, new File(PathConstants.featurePath()));
        for (String feature : features) {
            if (!featureName.equals(ALL_FEATURES) && !feature.endsWith(EXTENSION_FEATURE)) {
                feature += EXTENSION_FEATURE;
            }
            FeatureOverwrite.overwriteFeatureFileRemove(feature);
        }
        FeatureOverwrite.clearListFilesByFolder();
    }
}
