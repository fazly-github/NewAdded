package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TechfiosPage extends BasePage {

	WebDriver driver;
	int sizeBeforeRemoving = 0;
	int sizeAfterRemoving = 0;

	@FindBy(how = How.CSS, using = "ul li input")
	List<WebElement> LIST_OF_CHECKBOXES_ELEMENT;
	@FindBy(how = How.CSS, using = "input[name='allbox']")
	WebElement TOGGLE_ALL_CHECKBOXS_ELEMENT;
	@FindBy(how = How.CSS, using = "input[value='Remove']")
	WebElement REMOVE_BUTTON_ELEMENT;
	@FindBy(how = How.CSS, using = "ul li")
	List<WebElement> LIST_OF_CHECKBOXES_NAME_ELEMENT;
	@FindBy(how = How.CSS, using = "input[name='data']")
	WebElement CHECKBOX_NAME_ELEMENT;
	@FindBy(how = How.CSS, using = "input[value='Add']")
	WebElement ADD_BUTTON_ELEMENT;
	@FindBy(how = How.CSS, using = "div a[title='Remove this category']")
	List<WebElement> CATEGORIES_LIST_ELEMENT;
	@FindBy(how = How.NAME, using = "categorydata")
	WebElement CATEGORY_TEXT_BOX_ELEMENT;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement ADD_CATEGORY_BUTTON_ELEMENT;
	@FindBy(how = How.CSS, using = "select[name='due_month']")
	WebElement MONTHS_DROPDOWN_ELEMENT;

	public TechfiosPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addCheckBoxesAndClickAddButton() {

		for (int i = 0; i < 4; i++) {
			int ranNum = generateRandomNumbers(999);
			CHECKBOX_NAME_ELEMENT.sendKeys("NewCheckbox" + ranNum);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ADD_BUTTON_ELEMENT.click();
		}

	}

	public void clickOnToggleAllCheckbox() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TOGGLE_ALL_CHECKBOXS_ELEMENT.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean validateAllCheckboxesInListAreSelected() {

		boolean checked = true;
		for (int i = 0; i < LIST_OF_CHECKBOXES_ELEMENT.size(); i++) {
			checked = checked && LIST_OF_CHECKBOXES_ELEMENT.get(i).isSelected();
		}
		return checked;

	}

	public void clickOnSingleCheckbox() {

		sizeBeforeRemoving = LIST_OF_CHECKBOXES_ELEMENT.size();
		System.out.println("Size before Removing Checkbox/Checkboxes: " + sizeBeforeRemoving);

		System.out.println("Names of Checkboxes: ");
		for (int i = 0; i < LIST_OF_CHECKBOXES_NAME_ELEMENT.size(); i++) {

			System.out.println(LIST_OF_CHECKBOXES_NAME_ELEMENT.get(i).getText());

		}

		LIST_OF_CHECKBOXES_ELEMENT.get(1).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnRemoveButton() {

		REMOVE_BUTTON_ELEMENT.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sizeAfterRemoving = LIST_OF_CHECKBOXES_ELEMENT.size();
		System.out.println("Size After Removing Checkbox/Checkboxes: " + sizeAfterRemoving);
	}

	public boolean validateOneCheckboxRemoved() {

		boolean result = false;
		if (sizeAfterRemoving == sizeBeforeRemoving - 1) {
			result = true;
		}
		return result;

	}

	public boolean validateAllCheckBoxesRemoved() {

		boolean result = false;
		if (LIST_OF_CHECKBOXES_ELEMENT.size() == 0) {
			result = true;
		}
		return result;

	}

	public boolean addUniqueCategory(String categoryName) {

		int ranNum = generateRandomNumbers(9999);
		categoryName = categoryName + ranNum;
		CATEGORY_TEXT_BOX_ELEMENT.sendKeys(categoryName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ADD_CATEGORY_BUTTON_ELEMENT.click();

		boolean result = false;
		for (int i = CATEGORIES_LIST_ELEMENT.size() - 1; i > 10; i--) {
			if (categoryName.equalsIgnoreCase(CATEGORIES_LIST_ELEMENT.get(i).getText())) {
				result = true;
			}
		}
		System.out.println("This category is added: " + categoryName);
		return result;

	}

	public String addDuplicateCategoryName() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String duplicateName = CATEGORIES_LIST_ELEMENT.get(CATEGORIES_LIST_ELEMENT.size() - 1).getText();
		CATEGORY_TEXT_BOX_ELEMENT.sendKeys(duplicateName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ADD_CATEGORY_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return duplicateName;

	}

	public boolean validateListOfMonthDropDown() {

		List<String> listOfMonths = new ArrayList<String>();
		listOfMonths.add("Jan");
		listOfMonths.add("Feb");
		listOfMonths.add("Mar");
		listOfMonths.add("Apr");
		listOfMonths.add("May");
		listOfMonths.add("Jun");
		listOfMonths.add("Jul");
		listOfMonths.add("Aug");
		listOfMonths.add("Sep");
		listOfMonths.add("Oct");
		listOfMonths.add("Nov");
		listOfMonths.add("Dec");

		boolean match = true;

		List<WebElement> listOfMonthsInDropDown = getListFromDropDownList(MONTHS_DROPDOWN_ELEMENT);
		for (int i = 0; i < listOfMonthsInDropDown.size(); i++) {
			if (i == 0) {// Cause index of 0 has no value in our list we just pass this iteration
				continue;
			}
			if (!listOfMonthsInDropDown.get(i).getText().equalsIgnoreCase(listOfMonths.get(i - 1))) {

				match = match && false;

			}
		}

		if (match == true)
			System.out.println("All is good!");
		return match;

	}

}
