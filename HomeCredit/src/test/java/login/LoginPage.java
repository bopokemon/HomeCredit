package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import home.HomePage;

public class LoginPage {

	WebDriver driver;
	@FindBy(how = How.NAME, using = "uid")
	private WebElement txt_Username;
	@FindBy(how = How.NAME, using = "password")
	private WebElement txt_Password;
	@FindBy(how = How.NAME, using = "btnLogin")
	private WebElement btn_Login;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage navigateTo_HomePage() {
		btn_Login.click();
		return new HomePage(driver);
	}

	public void enter_the_Username_and_Password() throws Throwable {
		txt_Username.sendKeys("mngr304232");
		txt_Password.sendKeys("tevAzUz");
	}
}
