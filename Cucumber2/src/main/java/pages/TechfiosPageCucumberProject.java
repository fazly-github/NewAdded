package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TechfiosPageCucumberProject {

	WebDriver driver;

	@FindBy(how = How.CSS, using = "button:nth-child(12)")
	WebElement SET_SKYBLUE_BACKGROUND_BUTTON_ELEMENT;
	@FindBy(how = How.CSS, using = "button:nth-child(13)")
	WebElement SET_WHITE_BACKGROUND_BUTTON_ELEMENT;

	public TechfiosPageCucumberProject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkIfSkyBlueBackgroundButtonExists() {

		boolean result = SET_SKYBLUE_BACKGROUND_BUTTON_ELEMENT.isDisplayed();
		return result;
	}

	public void clickOnSetSkyBlueBackgroundButton() {

		SET_SKYBLUE_BACKGROUND_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean checkIfWhiteBackgroundButtonExists() {

		boolean result = SET_WHITE_BACKGROUND_BUTTON_ELEMENT.isDisplayed();
		return result;
	}

	public void clickOnSetWhiteBackgroundButton() {

		SET_WHITE_BACKGROUND_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}