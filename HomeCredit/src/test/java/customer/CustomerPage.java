package customer;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	WebDriver driver;
	@FindBy(how = How.NAME, using = "res")
	private WebElement btn_Reset;
	@FindBy(how = How.NAME, using = "sub")
	private WebElement btn_Submit;
	@FindBy(how = How.NAME, using = "name")
	private WebElement txt_CustomerName;
	@FindBy(how = How.XPATH, using = "//input[@value='m']")
	private WebElement rad_Male;
	@FindBy(how = How.XPATH, using = "//input[@value='f']")
	private WebElement rad_Female;
	@FindBy(how = How.ID, using = "dob")
	private WebElement txt_DateOfBirth;
	@FindBy(how = How.NAME, using = "addr")
	private WebElement txt_Address;
	@FindBy(how = How.NAME, using = "city")
	private WebElement txt_City;
	@FindBy(how = How.NAME, using = "state")
	private WebElement txt_State;
	@FindBy(how = How.NAME, using = "pinno")
	private WebElement txt_Pin;
	@FindBy(how = How.NAME, using = "telephoneno")
	private WebElement txt_Mobile;
	@FindBy(how = How.NAME, using = "emailid")
	private WebElement txt_email;
	@FindBy(how = How.NAME, using = "password")
	private WebElement txt_password;
	@FindBy(how = How.XPATH, using = "//table[@id=\"customer\"]/tbody/tr[1]/td/p")
	private WebElement txt_Message;
	@FindBy(how = How.XPATH, using = "//table[@id=\"customer\"]/tbody/tr[4]/td[2]")
	private WebElement txt_CustomerID;
	@FindBy(how = How.XPATH, using = "//a[text()='Home']")
	private WebElement lnk_Home;
	
	// Roll back data
	@FindBy(how = How.XPATH, using = "//ul[@class='menusubnav']/li[4]/a")
	private WebElement deleteCustomer;
	@FindBy(how = How.NAME, using = "cusid")
	private WebElement txt_deleteCustomerID;
	@FindBy(how = How.NAME, using = "AccSubmit")
	private WebElement txt_deleteSubmit;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enter_customer_information(String CustomerName, String Gender, String DateOfBirth, String Address,
			String City, String State, String Pin, String Mobile, String email, String password) {
		txt_CustomerName.sendKeys(CustomerName);
		if (Gender.equals("Male"))
			rad_Male.click();
		else
			rad_Female.click();

		txt_DateOfBirth.sendKeys(DateOfBirth);
		txt_Address.sendKeys(Address);
		txt_City.sendKeys(City);
		txt_State.sendKeys(State);
		txt_Pin.sendKeys(Pin);
		txt_Mobile.sendKeys(Mobile);
		txt_email.sendKeys(email);
		txt_password.sendKeys(password);
	}

	public void ResetData() {
		btn_Reset.click();
	}

	public void SubmitData() {
		btn_Submit.click();
		String actual = txt_Message.getText();
		String expected = "Customer Registered Successfully!!!";
		Assert.assertEquals(actual, expected);
		String customerID = txt_CustomerID.getText();
		// Roll back data
		System.out.println("CustomerID: " + customerID);
		deleteCustomer.click();
		txt_deleteCustomerID.sendKeys(customerID);
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
