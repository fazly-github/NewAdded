package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.DashBoardPage;
import pages.DatabasePage;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase {

	LoginPage loginPage;
	DashBoardPage dashboardPage;
	NewAccountPage newAccountPage;

	DatabasePage databasePage;

	@Before
	public void beforeRun() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		newAccountPage = PageFactory.initElements(driver, NewAccountPage.class);
		databasePage = new DatabasePage();
	}

	@Given("^User is on the techfios login page$")
	public void user_is_on_the_techfios_login_page() {

		driver.get("https://techfios.com/billing/?ng=login/");

	}

	@When("^User enters the \"([^\"]*)\" in the \"([^\"]*)\" field$")
	public void user_enters_the_in_the_field(String loginInfo, String field) {
		if (field.equalsIgnoreCase("username")) {
			loginPage.enterUserName(loginInfo);
		} else if (field.equalsIgnoreCase("password")) {
			loginPage.enterPassword(loginInfo);
		} else {
			System.out.println("Incorrect login information!!");
		}
	}
//	
//	@When("User enters the {string} from mysql database")

	@When("User enters the {string} from mysql database")
	public void user_enters_from_mysql_databes(String userData) {
//		if (userData.equalsIgnoreCase("username")) {
//			System.out.println("Username from DB:" + databasePage.getDataFromDB());
//			loginPage.enterUserName(databasePage.getDataFromDB());
//		} else if (userData.equalsIgnoreCase("password")) {
//			System.out.println("Password from DB:" + databasePage.getDataFromDB());
//			loginPage.enterPassword(databasePage.getDataFromDB());
//		} else {
//			System.out.println("User data " + userData + "is not found");
//		}

		switch (userData) {
		case "username":
			System.out.println("Username from DB:" + databasePage.getDataFromDB("username"));
			loginPage.enterUserName(databasePage.getDataFromDB("username"));
			break;
		case "password":
			System.out.println("Password from DB:" + databasePage.getDataFromDB("password"));
			loginPage.enterPassword(databasePage.getDataFromDB("password"));
			break;
		default:
			System.out.println("User data " + userData + "is not found");
		}

	}

	@When("^User clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String button) {
		if (button.equalsIgnoreCase("login")) {
			loginPage.clickSignInButton();
		} else if (button.equalsIgnoreCase("bankCash")) {
			dashboardPage.clickBankAndCashButton();
		} else if (button.equalsIgnoreCase("newAccount")) {
			dashboardPage.clicknewAccountButtonElement();
		} else if (button.equalsIgnoreCase("submit")) {
			newAccountPage.clickOnSubminButton();
		}
	}

	@Then("^User should land on Dashboard page$")
	public void user_should_land_on_Dashboard_page() {
		String actualText = dashboardPage.getPageTitle();
		String expectedText = "Dashboard- iBilling";
		Assert.assertEquals("Page title does not match", expectedText, actualText);

	}

	@Then("^User enters \"([^\"]*)\" in the \"([^\"]*)\" field in accounts page$")
	public void user_enters_in_the_field_in_accounts_page(String accountData, String field) {
		switch (field) {
		case "accountTitle":
			newAccountPage.addAccountTitle(accountData + generatedRandomNumber(999));
			break;
		case "description":
			newAccountPage.enterDescription(accountData + generatedRandomNumber(999));
			break;
		case "initialBalance":
			newAccountPage.enterInitialBalance(accountData + generatedRandomNumber(999));
			break;
		case "accountNumber":
			newAccountPage.enterAccountNumber(accountData + generatedRandomNumber(999));
			break;
		case "contactPerson":
			newAccountPage.enterContactPerson(accountData + generatedRandomNumber(999));
			break;
		case "Phone":
			newAccountPage.addPhone(accountData + generatedRandomNumber(999));
			break;
		case "internetBankingURL":
			newAccountPage.enterInternetBankingURL(accountData + generatedRandomNumber(999));
			break;
		default:
			System.out.println("Incorect data:" + accountData);
		}
	}

	@Then("^User should be able to validate account created successfully$")
	public void user_should_be_able_to_validate_account_created_successfully() {
		takeScreenshot(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
