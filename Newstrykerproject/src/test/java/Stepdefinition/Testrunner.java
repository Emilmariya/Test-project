package Stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/CardiacICU.feature",glue={"Stepdefinition"},
dryRun=false,
monochrome = true,
//plugin = {"json:target/cucumber.json"})
plugin = {
		  "pretty","junit:target/JUNITreports/report.xml",
		  "json:target/Cucumber/cucumber.json",
                "html:target/Htmlreports/report.html"
               }

)
//json:target/JSONreports/report.json
// "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//html:target/Htmlreports/report.html
public class Testrunner {

}
