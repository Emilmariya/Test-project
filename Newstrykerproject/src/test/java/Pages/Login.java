package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	

	@FindBy(xpath="//input[@type='password']")
	WebElement txt_hospitalcode;
	
	@FindBy(xpath="//button[@class='loginbtn']")
	WebElement txt_proceed;
	
	WebDriver pdriver;
	
	public Login(WebDriver driver) {
		this.pdriver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterhospitalcode(String hospitalcode)
	{
		txt_hospitalcode.sendKeys(hospitalcode);
		
	}
	
	public void clickOnProceedButton() {
		
		txt_proceed.click();
	}
	

}
