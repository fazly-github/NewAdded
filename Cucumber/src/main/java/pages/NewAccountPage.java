package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewAccountPage {

	WebDriver driver;

	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

//	Element list:
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a")
	WebElement bankAndCash;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")
	WebElement clickOnNewAccount;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement AccountTitle;
	@FindBy(how = How.XPATH, using = "//*[@id=\"description\"]")
	WebElement AddDescription;
	@FindBy(how = How.XPATH, using = "//*[@id=\"balance\"]")
	WebElement AddInitialBalance;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account_number\"]")
	WebElement AddAccountNumber;
	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_person\"]")
	WebElement AddContactPerson;
	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_phone\"]")
	WebElement AddPhone;
	@FindBy(how = How.XPATH, using = "//*[@id=\"ib_url\"]")
	WebElement AddInternetBankingURL;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")
	WebElement SubmitButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/button")
	WebElement accountCreatedSuccessfullyElement;

//	Methods to interact with the elements 

	public void clickOnBankAndCash() {
		bankAndCash.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addNewAccount() {
		clickOnNewAccount.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Accounts- iBilling
	public String getPageTitleAccount() {
		return driver.getTitle();
	}

//add Account

	public void addAccountTitle(String accountTitle) {
		AccountTitle.sendKeys(accountTitle);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	description

	public void enterDescription(String description) {
		AddDescription.sendKeys(description);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterInitialBalance(String initialBalance) {
		AddInitialBalance.sendKeys(initialBalance);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterAccountNumber(String accountNumber) {
		AddAccountNumber.sendKeys(accountNumber);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterContactPerson(String contactPerson) {
		AddContactPerson.sendKeys(contactPerson);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPhone(String phone) {
		AddPhone.sendKeys(phone);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterInternetBankingURL(String internetBankingURL) {
		AddInternetBankingURL.sendKeys(internetBankingURL);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSubminButton() {
		SubmitButton.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAccountCreation() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		accountCreatedSuccessfullyElement.click();
		System.out.println("Account created successfully");
	}

}
