package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public int generateRandomNumbers(int boundary) {
		Random random = new Random();
		int ranNumber = random.nextInt(boundary);
		return ranNumber;

	}

	public List<WebElement> getListFromDropDownList(WebElement element) {
		Select sel = new Select(element);
		List<WebElement> list = sel.getOptions();
		return list;
	}
}
