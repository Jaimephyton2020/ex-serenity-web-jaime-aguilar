package com.qa.automationtest.util;

import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AttachScreenshotToScenario {
    static PropertiesReader readProperties = new PropertiesReader();
    private final DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public void addScreenshot(Scenario scenario) {
        scenario.attach(
                ((TakesScreenshot) BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver()).getScreenshotAs(OutputType.BYTES),
                "image/png",
                String.format("%s %s.jpg", scenario.getName(), formatDate.format(new Date()))
        );
    }

    public void addScreenshotManualTest(Scenario scenario) throws IOException {
        String[] tagsScenario = scenario.getSourceTagNames().toArray(new String[0]);
        for (String lineTag : tagsScenario) {
            if (lineTag.contains("@manual-test-evidence:")) {
                String[] numberEvidence = lineTag.split(",");
                for (String e : numberEvidence) {
                    String nameEvidence = StringUtils.substringBetween(e, "(", ")");
                    nameEvidence = nameEvidence.substring(6);
                    FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + PathConstants.validatePath(readProperties.getPropiedad("report.assets.directory")) + nameEvidence);
                    byte[] fileInBytes = IOUtils.toByteArray(fileInputStream);
                    validateFileType(nameEvidence, scenario, fileInBytes);
                }
            }
        }
    }

    private void validateFileType(String nameEvidence, Scenario scenario, byte[] fileInBytes) {
        if (nameEvidence.endsWith(".png") || nameEvidence.endsWith(".jpg") || nameEvidence.endsWith(".jpeg")) {
            scenario.attach(fileInBytes,
                    "image/png",
                    String.format("%s %s.jpg", scenario.getName(), formatDate.format(new Date())));
        } else if (nameEvidence.endsWith(".txt")) {
            scenario.attach(fileInBytes,
                    "text/plain",
                    String.format("%s %s.txt", scenario.getName(), formatDate.format(new Date())));
        } else if (nameEvidence.endsWith(".docx")) {
            scenario.attach(fileInBytes,
                    "application/msword",
                    String.format("%s %s.docx", scenario.getName(), formatDate.format(new Date())));
        } else if (nameEvidence.endsWith(".rar")) {
            scenario.attach(fileInBytes,
                    "application/x-rar-compressed",
                    String.format("%s %s.rar", scenario.getName(), formatDate.format(new Date())));
        } else if (nameEvidence.endsWith(".zip")) {
            scenario.attach(fileInBytes,
                    "application/zip",
                    String.format("%s %s.zip", scenario.getName(), formatDate.format(new Date())));
        } else {
            throw new IllegalStateException();
        }
    }
}