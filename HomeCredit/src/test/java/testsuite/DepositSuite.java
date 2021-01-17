package testsuite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features/Deposit.feature",glue={"StepDefinitionDeposit"})
public class DepositSuite {

}
