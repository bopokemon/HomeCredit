package StepDefinitionAddCustomer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import customer.CustomerPage;
import home.HomePage;
import login.LoginPage;

public class Steps {
	WebDriver driver;
	HomePage home;
	CustomerPage customer;

	@Given("^Open add customer page$")
	public void open_add_customer_page() throws Throwable {
		open_the_Chrome_and_launch_the_application();
		LoginPage login = new LoginPage(driver);
		login.enter_the_Username_and_Password();
		home = login.navigateTo_HomePage();
	}

	@When("^Enter customer information$")
	public void enter_customer_information(DataTable table) throws Throwable {
		customer = home.navigateTo_AddCustomerPage();
		List<List<String>> rows = table.raw();
		customer.enter_customer_information(rows.get(1).get(1), rows.get(2).get(1), rows.get(3).get(1),
				rows.get(4).get(1), rows.get(5).get(1), rows.get(6).get(1), rows.get(7).get(1), rows.get(8).get(1),
				rows.get(9).get(1), rows.get(10).get(1));
	}
	
	@When("^Click on Home link$")
	public void click_home_link() throws Throwable {
		customer = home.navigateTo_AddCustomerPage();
		customer.click_home_link();
	}

	@Then("^Reset the credential$")
	public void Reset_the_credential() throws Throwable {
		customer.ResetData();
		close_the_Chrome_and_launch_the_application();
	}
	
	@Then("^Submit the credential$")
	public void Submit_the_credential() throws Throwable {
		customer.SubmitData();
		close_the_Chrome_and_launch_the_application();
	}
	
	@Then("^Open home page$")
	public void Open_Home_Page() throws Throwable {
		customer.OpenHomePage();
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
