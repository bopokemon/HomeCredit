package StepDefinitionDeposit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import deposit.Deposit;
import home.HomePage;
import login.LoginPage;

public class Steps {
	WebDriver driver;
	HomePage home;
	Deposit depositPage;

	@Given("^Open deposit page$")
	public void open_deposit_page() throws Throwable {
		open_the_Chrome_and_launch_the_application();
		LoginPage login = new LoginPage(driver);
		login.enter_the_Username_and_Password();
		home = login.navigateTo_HomePage();
		home.close_advertisement();
	}

	@When("^Enter deposit information$")
	public void enter_customer_information(DataTable table) throws Throwable {
		depositPage = home.navigateTo_DepositPage();
		List<List<String>> rows = table.raw();
		depositPage.enter_deposit_information(rows.get(1).get(1), rows.get(2).get(1), rows.get(3).get(1));
	}

	@When("^Click on Home link$")
	public void click_home_link() throws Throwable {
		depositPage = home.navigateTo_DepositPage();
		depositPage.click_home_link();
	}

	@Then("^Reset the credential$")
	public void Reset_the_credential() throws Throwable {
		depositPage.ResetData();
		close_the_Chrome_and_launch_the_application();
	}

	@Then("^Submit the credential (\\d+)$")
	public void Submit_the_credential(String AccountNo) throws Throwable {
		depositPage.SubmitData(AccountNo);
		close_the_Chrome_and_launch_the_application();
	}

	@Then("^Open home page$")
	public void Open_Home_Page() throws Throwable {
		depositPage.OpenHomePage();
		close_the_Chrome_and_launch_the_application();
	}

	public void open_the_Chrome_and_launch_the_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4");
	}

	public void close_the_Chrome_and_launch_the_application() throws Throwable {
		driver.close();
		driver.quit();
	}
}
