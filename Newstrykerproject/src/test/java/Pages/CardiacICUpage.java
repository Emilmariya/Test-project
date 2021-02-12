package Pages;

import java.util.List;

//import java.awt.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardiacICUpage {

	@FindBy(xpath="//a[@class='logo']")
	WebElement txt_logo;

	@FindBy(xpath="//div[@class='smartMediclogo']")
	WebElement txt_smartmediclogo;


	@FindBy(xpath="//span[text()='SmartMedic Demo']")
	WebElement txt_smartmedicdemo;

	@FindBy(xpath="//a[contains(@class,'icuUnit')]")
	WebElement btn_cardioICU;

	@FindBy(xpath="//h2[contains(text(),'Cardiac ICU')]")
	WebElement txt_cardioICU;

	@FindBy(xpath="//h2[contains(text(),'Bed No.')]")
	WebElement txt_bedno;
	
	@FindBy(xpath="//div[@class='bednumber']")
	WebElement txt_bednumber;
	
	@FindBy(xpath="//*[name()='svg']//*[local-name()='g' and @class='apexcharts-inner apexcharts-graphical']")
	WebElement svg_graph007;

	@FindBy(xpath="//*[name()='svg']//*[local-name()='g' and @transform='translate(76.45373958333333, 80)']")
	WebElement svg_graph006;
	

	//pediatric
	@FindBy(xpath="//h2[contains(text(),'Pediatric ICU')]")
	WebElement txt_pediatricICU;
	
	@FindBy(xpath="//*[name()='svg']//*[local-name()='g' and @transform='translate(0, 55)']")
	WebElement svg_graph002;
	
	WebDriver cdriver;

	public CardiacICUpage(WebDriver driver) {
		this.cdriver=driver;
		PageFactory.initElements(driver,this);
	}

	public void checklogoDisplayed()
	{
		txt_logo.isDisplayed();
	}

	public void checksamrtMediclogoDisplayed()
	{
		txt_smartmediclogo.isDisplayed();
	}

	public void checksamrtMediclDemoDisplayed()
	{
		txt_smartmedicdemo.isDisplayed();
	}

	public void clickOnCardioButton() {

		btn_cardioICU.click();
	}

	public void checkcardiacICUisDisplayed() {

		txt_cardioICU.isDisplayed();
	}
	
//	public String bednoisDisplayed() {
//
//		return txt_bednumber.getText();
//	}

	public WebElement verifysvggraphisDisplayed() {

		return svg_graph007;
	}
	
	public WebElement verifysvggraphforsixisDisplayed() {

		return svg_graph006;
	}
	
	//pediatric
	
	public void checkpediatricICUisDisplayed() {

		txt_pediatricICU.isDisplayed();
	}
	public WebElement verifysvggraphforpediatricisDisplayed() {

		return svg_graph002;
	}
}
