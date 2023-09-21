package org.selenium.pom.Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/Resource/Login.feature",
        glue = "org.selenium.pom.StepDefinition")
public class TestNgTestRunner extends AbstractTestNGCucumberTests {


}
