package testsuite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features/AddAccount.feature",glue={"StepDefinitionAddAccount"})
public class AddAccountSuite {

}
