package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashBoardPage {

	WebDriver driver;
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	Element Library:
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a")
	WebElement bankAndCashButtonElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")
	WebElement newAccountButtonElement;
	
//	Methods to interact with the elements
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void clickBankAndCashButton() {
		bankAndCashButtonElement.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void clicknewAccountButtonElement () {
		newAccountButtonElement.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}
