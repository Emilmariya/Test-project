package Stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

import Pages.CardiacICUpage;
import Pages.Login;
import Pages.Pediatricpage;
import io.cucumber.java.en.*;

public class Pediatric {
	public WebDriver driver;
	Login log;
	Pediatricpage pediatric;
	
	@Given("user is on the browser page screen")
	public void user_is_on_the_browser_page_screen() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");   
		driver = new ChromeDriver();
	}



	@And("user on the URL {string}")
	public void user_on_the_url(String url) {
		driver.get("https://nurse-app.azurewebsites.net/");
		
	}
	@When("user enter hospital code")
	public void user_enter_hospital_code() {
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12349");
		
	}
	@And("user press proceed button")
	public void user_press_proceed_button() throws InterruptedException {
		log=new Login(driver);
		log.clickOnProceedButton();
		Thread.sleep(2000);
		
	}
	@Then("page navigate to stryker home page")
	public void page_navigate_to_stryker_home_page() throws InterruptedException {
		String actualTitle = driver.getTitle();
		String expectedTitle = "NSA";
		AssertJUnit.assertEquals(expectedTitle,actualTitle);
		Thread.sleep(2000);
		
	}
	@And("user verify the strykerlogo")
	public void user_verify_the_strykerlogo() throws InterruptedException {
		pediatric=new Pediatricpage(driver);
		pediatric.checklogoDisplayed();
		Thread.sleep(2000);
	}
	@And("user verify the Smartmediclogo")
	public void user_verify_the_smartmediclogo() throws InterruptedException {
		pediatric.checksamrtMediclogoDisplayed();
		Thread.sleep(2000);
}
	@And("user verify the Smartmedicdemo")
	public void user_verify_the_smartmedicdemo() throws InterruptedException {
		pediatric.checksamrtMediclDemoDisplayed();
		Thread.sleep(2000);
	}
	@And("^user clicks on the ICU button (.*)$")
	public void user_clicks_on_the_icu_button(String ICUname) throws InterruptedException {
		//pediatric.clickOPediatricButton();
		
		List <WebElement> iculist = driver.findElements(By.xpath("//a[contains(@class,'icuUnit')]"));

			for(WebElement icuelement:iculist)
			{
				String Listname=icuelement.getText();
	
				System.out.println(Listname);
				System.out.println(ICUname);
	
				if(Listname.equals(ICUname)) {
					icuelement.click();
					Thread.sleep(3000);
					break;
				}
	
			}
	
			Thread.sleep(2000);
		}
		
		
	

	@Then("user navigate to pediatric page")
	public void user_navigate_to_pediatric_page() throws InterruptedException {
		pediatric.checksvgimageisDisplayed();
		pediatric.checkpediatricICUisDisplayed();
		Thread.sleep(2000);
		
		
		driver.close();
		driver.quit();
	}
	
	//selecting bed and verify the bed screen
	
	@Then("^user click on the ICU button from the home screen (.*)$")
	public void user_click_on_the_icu_button_from_the_home_screen(String ICUname) throws InterruptedException {
		//pediatric.clickOnthePediatricButton(); //selecting the pediatric ICU

		List <WebElement> iculist = driver.findElements(By.xpath("//a[contains(@class,'icuUnit')]"));

		for(WebElement icuelement:iculist)
		{
			String Listname=icuelement.getText();

			System.out.println(Listname);
			System.out.println(ICUname);

			if(Listname.equals(ICUname)) {
				icuelement.click();
				Thread.sleep(3000);
				break;
			}

		}

		Thread.sleep(2000);
	}
	
	
	@And("^click on the bedno Bed No.(.*)$")
	public void click_on_the_bedno_bed_no(String bednumb) throws InterruptedException {
		
		List <WebElement> bedlist = driver.findElements(By.xpath("//div[@class='bednumber']"));

		for(WebElement bedelement:bedlist)
		{
			String bedname=bedelement.getText();

			System.out.println(bedname);
			System.out.println(bednumb);

			if(bednumb.equals(bedname)) {
				bedelement.click();
				Thread.sleep(3000);
				break;
			}

		}

		Thread.sleep(2000);
	}	
	
//	@Then("verify the selected bed screen")
//	public void verify_the_selected_bed_screen() throws InterruptedException {
//		pediatric=new Pediatricpage(driver);
//		pediatric.checklogoDisplayed();
//		pediatric.checksamrtMediclogoDisplayed();
//		pediatric.checksamrtMediclDemoDisplayed();
//		pediatric.checksvgimageisDisplayed();
//		
//		if(driver.getPageSource().contains("Bed No. 002"))
//			{
//				System.out.println("Bed no. is diaplayed");
//			}
//		Thread.sleep(2000);
//		if(driver.getPageSource().contains("Patient Weight Trend"))
//		{
//			System.out.println("====Pateint Weight Trend is displayed=====");
//		}
//		if(driver.getPageSource().contains("Patient Turn Log"))
//		{
//			System.out.println("====Pateint Trun Log is displayed=====");
//		}
//		pediatric=new Pediatricpage(driver);
//		String graph = pediatric.verifysvggraphisDisplayed().getAttribute("id");
//		System.out.println("===The id of the graph is="+graph);
//		
//		driver.close();
//		driver.quit();
//	
//		
//	}
}
