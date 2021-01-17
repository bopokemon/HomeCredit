package deposit;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Deposit {
	WebDriver driver;
	@FindBy(how = How.NAME, using = "res")
	private WebElement btn_Reset;
	@FindBy(how = How.NAME, using = "accountno")
	private WebElement txt_accountno;
	@FindBy(how = How.NAME, using = "ammount")
	private WebElement txt_amount;
	@FindBy(how = How.NAME, using = "desc")
	private WebElement txt_description;
	@FindBy(how = How.NAME, using = "AccSubmit")
	private WebElement btn_Submit;
	@FindBy(how = How.XPATH, using = "//table[@id=\"deposit\"]/tbody/tr[1]/td/p")
	private WebElement txt_Message;
	@FindBy(how = How.XPATH, using = "//a[text()='Home']")
	private WebElement lnk_Home;
	
	public Deposit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enter_deposit_information(String AccountID, String Amount, String Description) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		txt_accountno.sendKeys(AccountID);
		txt_amount.sendKeys(Amount);
		txt_description.sendKeys(Description);
	}
	
	public void ResetData() {
		btn_Reset.click();
	}
	
	public void SubmitData(String AccountID) {
		btn_Submit.click();
		String actual = txt_Message.getText();
		String expected = "Transaction details of Deposit for Account " + AccountID;
		Assert.assertEquals(actual, expected);
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
