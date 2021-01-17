package StepDefinitionAddAccount;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import account.AccountPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import home.HomePage;
import login.LoginPage;

public class Steps {
	WebDriver driver;
	HomePage home;
	AccountPage account;
	@Given("^Open add account page$")
	public void open_add_customer_page() throws Throwable {
		open_the_Chrome_and_launch_the_application();
		LoginPage login = new LoginPage(driver);
		login.enter_the_Username_and_Password();
		home = login.navigateTo_HomePage();
	}

	@When("^Enter account information$")
	public void enter_customer_information(DataTable table) throws Throwable {
		account = home.navigateTo_AddAccountPage();
		List<List<String>> rows = table.raw();
		account.enter_account_information(rows.get(1).get(1), rows.get(2).get(1), rows.get(3).get(1));
	}
	
	@When("^Click on Home link$")
	public void click_home_link() throws Throwable {
		account = home.navigateTo_AddAccountPage();
		account.click_home_link();
	}

	@Then("^Reset the credential$")
	public void Reset_the_credential() throws Throwable {
		account.ResetData();
		close_the_Chrome_and_launch_the_application();
	}
	
	@Then("^Submit the credential$")
	public void Submit_the_credential() throws Throwable {
		account.SubmitData();
		close_the_Chrome_and_launch_the_application();
	}
	
	@Then("^Open home page$")
	public void Open_Home_Page() throws Throwable {
		account.OpenHomePage();
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
