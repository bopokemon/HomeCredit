package home;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import account.AccountPage;
import customer.CustomerPage;
import deposit.Deposit;

public class HomePage {
	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//ul[@class='menusubnav']/li[2]/a")
	private WebElement addCustomer;
	@FindBy(how = How.XPATH, using = "//ul[@class='menusubnav']/li[5]/a")
	private WebElement addAccount;
	@FindBy(how = How.XPATH, using = "//ul[@class='menusubnav']/li[8]/a")
	private WebElement depositAccount;
	@FindBy(how = How.ID, using = "aswift_0")
	private WebElement iframe;
	@FindBy(how = How.ID, using = "cbb")
	private WebElement closeAdvertisement;
	@FindBy(how = How.ID, using = "report_text")
	private WebElement stopAdvertisement;
	@FindBy(how = How.XPATH, using = "//div[@id=\"option-container\"]/a[4]")
	private WebElement optionAdvertisement;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CustomerPage navigateTo_AddCustomerPage() {
		addCustomer.click();
		return new CustomerPage(driver);
	}

	public AccountPage navigateTo_AddAccountPage() {
		addAccount.click();
		return new AccountPage(driver);
	}

	public Deposit navigateTo_DepositPage() {
		driver.get("http://demo.guru99.com/v4/manager/DepositInput.php");
		return new Deposit(driver);
	}

	public void close_advertisement() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(iframe);
		closeAdvertisement.click();
		stopAdvertisement.click();
		optionAdvertisement.click();
	}
}
