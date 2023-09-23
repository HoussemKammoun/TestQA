package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="Ressources/Features",
		glue="stepDefinitions"
		)
public class Runner extends  AbstractTestNGCucumberTests {

}
