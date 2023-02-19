package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.TechfiosPageOfJUnit;
import pages.TestBaseJUnit;

public class AutomationPojectOfJUnitTest {

	WebDriver driver;
	TechfiosPageOfJUnit tfPage;

	@Before()
	public void setUp() {
		driver = TestBaseJUnit.initDriver();
		tfPage = PageFactory.initElements(driver, TechfiosPageOfJUnit.class);

	}

	@Test
	public void validate1() {
		tfPage.addCheckBoxesAndClickAddButton();
		tfPage.clickOnToggleAllCheckbox();
		boolean result = tfPage.validateAllCheckboxesInListAreSelected();
		Assert.assertTrue("Checkboxes are not selected", result);

	}

	@Test
	public void validate2() {
		tfPage.clickOnSingleCheckbox();
		tfPage.clickOnRemoveButton();
		boolean result = tfPage.validateOneCheckboxIsRemoved();
		Assert.assertTrue("A checkbox is not removed !!!", result);
	}

	@Test
	public void validate3() {
		tfPage.clickOnToggleAllCheckbox();
		tfPage.clickOnRemoveButton();
		boolean result = tfPage.validateAllCheckBoxesAreRemoved();
		Assert.assertTrue("List of checkboxes is not empty", result);
	}

	@After
	public void tearDown() {
		TestBaseJUnit.tearDown();
	}
}
