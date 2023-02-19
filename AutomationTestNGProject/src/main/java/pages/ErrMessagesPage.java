package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ErrMessagesPage {

	WebDriver driver;
	@FindBy(how = How.CSS, using = "body")
	WebElement ERR_MESSAGE_ELEMENT;

	public ErrMessagesPage(WebDriver driver) {
		this.driver = driver;
	}

	public String validateError() {

		System.out.println(ERR_MESSAGE_ELEMENT.getText());
		return ERR_MESSAGE_ELEMENT.getText();

	}
}
