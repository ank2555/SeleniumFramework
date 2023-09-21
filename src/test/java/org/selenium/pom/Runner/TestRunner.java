package org.selenium.pom.Runner;


import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        features = "src/test/Resource/Login.feature",
        glue = "Definitions")
public class TestRunner {


}
