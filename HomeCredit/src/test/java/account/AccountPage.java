package account;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {
	WebDriver driver;

	@FindBy(how = How.NAME, using = "reset")
	private WebElement btn_Reset;
	@FindBy(how = How.NAME, using = "cusid")
	private WebElement txt_CustomerID;
	@FindBy(how = How.NAME, using = "selaccount")
	private WebElement sel_CustomerID;
	@FindBy(how = How.NAME, using = "inideposit")
	private WebElement txt_Deposit;
	@FindBy(how = How.NAME, using = "button2")
	private WebElement btn_Submit;
	@FindBy(how = How.XPATH, using = "//table[@id=\"account\"]/tbody/tr[1]/td/p")
	private WebElement txt_Message;
	@FindBy(how = How.XPATH, using = "//table[@id=\"account\"]/tbody/tr[4]/td[2]")
	private WebElement txt_AccountID;

	// Roll back data
	@FindBy(how = How.XPATH, using = "//ul[@class='menusubnav']/li[7]/a")
	private WebElement deleteAccount;
	@FindBy(how = How.NAME, using = "accountno")
	private WebElement txt_deleteAccountID;
	@FindBy(how = How.NAME, using = "AccSubmit")
	private WebElement txt_deleteSubmit;
	@FindBy(how = How.XPATH, using = "//a[text()='Home']")
	private WebElement lnk_Home;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ResetData() {
		btn_Reset.click();
	}

	public void enter_account_information(String CustomerID, String AccountType, String Deposit) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		txt_CustomerID.sendKeys(CustomerID);
		Select drpAccountType = new Select(sel_CustomerID);
		drpAccountType.selectByValue(AccountType);
		txt_Deposit.sendKeys(Deposit);
	}

	public void SubmitData() {
		btn_Submit.click();
		String actual = txt_Message.getText();
		String expected = "Account Generated Successfully!!!";
		Assert.assertEquals(actual, expected);
		String accountID = txt_AccountID.getText();
		// Roll back data
		System.out.println("AccountID: " + accountID);
		deleteAccount.click();
		txt_deleteAccountID.sendKeys(accountID);
		txt_deleteSubmit.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
	}

	public void click_home_link() {
		lnk_Home.click();
	}

	public void OpenHomePage() {
		String actual = driver.getCurrentUrl();
		String expected = "http://demo.guru99.com/v4/manager/Managerhomepage.php";
		Assert.assertEquals(actual, expected);
	}
}
