package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pediatricpage {

	@FindBy(xpath="//a[@class='logo']")
	WebElement txt_logo;
	
	@FindBy(xpath="//div[@class='smartMediclogo']")
	WebElement txt_smartmediclogo;


	@FindBy(xpath="//span[text()='SmartMedic Demo']")
	WebElement txt_smartmedicdemo;
	
	@FindBy(xpath="//a[contains(text(),'Pediatric ICU')]")
	WebElement btn_pediacICU;
	
	@FindBy(xpath="//*[name()='svg']//*[local-name()='path' and @d='M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z']")
	WebElement svg_image;

	@FindBy(xpath="//h2[contains(text(),'Pediatric ICU')]")
	WebElement txt_pediacICU;
	
	@FindBy(xpath="//*[name()='svg']//*[local-name()='g' and @transform='translate(0, 55)']")
	WebElement svg_graph002;
	
	WebDriver pdriver;

	public Pediatricpage(WebDriver driver) {
		this.pdriver=driver;
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

	public void clickOPediatricButton() {

		btn_pediacICU.click();
	}
	
	public void clickOnthePediatricButton() {

		btn_pediacICU.click();
	}
	
	public void checksvgimageisDisplayed()
	{
		svg_image.isDisplayed();
	}
	public void checkpediatricICUisDisplayed()
	{
		txt_pediacICU.isDisplayed();
	}
	
	public WebElement verifysvggraphisDisplayed() {

		return svg_graph002;
	}
}
