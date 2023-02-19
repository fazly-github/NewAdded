package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ErrMessagesPage;
import pages.TechfiosPage;
import pages.TestBase;

public class AutomationProjectOfTestNGTest {

	WebDriver driver;
	TechfiosPage tfPage;
	ErrMessagesPage errMsgPage;

	@BeforeMethod
	public void setUp() {
		driver = TestBase.initDriver();
		tfPage = PageFactory.initElements(driver, TechfiosPage.class);
		errMsgPage = PageFactory.initElements(driver, ErrMessagesPage.class);
	}

	@Test(priority = 1)
	public void userShouldBeAbleToAddUniqueCategoryName() {
		boolean result = tfPage.addUniqueCategory("TestNGProject");
		Assert.assertTrue(result, "Unable to add Category");
	}

	@Test(priority = 2)
	public void userShouldBeUnableToAddDupicateCategoryName() {
		String duplicateName = tfPage.addDuplicateCategoryName();
		String errMsg = errMsgPage.validateError();
		Assert.assertTrue(errMsg.contains(duplicateName), "Error!!! Duplicate Category added");

	}

	@Test(priority = 3)
	public void validateMonthsDropDown() {
		boolean match = tfPage.validateListOfMonthDropDown();
		Assert.assertTrue(match, "Months are not matching !!!");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
