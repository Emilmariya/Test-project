package Stepdefinition;

import java.sql.Driver;

//import java.awt.List;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;

import Pages.CardiacICUpage;
import Pages.Login;
//import driver.findElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CardiacICU {

	public WebDriver driver;
	Login log;
	CardiacICUpage Cardio;

	@Given("user in on browser page")
	public void user_in_on_browser_page() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");   
		driver = new ChromeDriver();
	}


	@When("user open the URL {string}")
	public void user_open_the_url(String url) {
		driver.get(url);
	}

	@And("user type hospitalcode")
	public void user_type_hospitalcode() {
		driver.findElement(By.xpath("input[@type='password']")).sendKeys("12349");

	}

	@And("user click on the login button")
	public void user_click_on_the_login_button() throws InterruptedException {
		log=new Login(driver);
		log.clickOnProceedButton();
		Thread.sleep(2000);
	}

	@Then("user navigate to home page")
	public void user_navigate_to_home_page() throws InterruptedException {
		String actualTitle = driver.getTitle();
		String expectedTitle = "NSA";
		AssertJUnit.assertEquals(expectedTitle,actualTitle);
		Thread.sleep(2000);
	}

	@And("user verify logo")
	public void user_verify_logo() throws InterruptedException {
		Cardio=new CardiacICUpage(driver);
		Cardio.checklogoDisplayed();
		Thread.sleep(2000);
	}


	@And("user verify smartmediclogo")
	public void user_verify_smartmediclogo() throws InterruptedException {
		Cardio.checksamrtMediclogoDisplayed();
		Thread.sleep(2000);

	}

	@And("user verify smartmedic demo")
	public void user_verify_smartmedic_demo() throws InterruptedException {
		Cardio.checksamrtMediclDemoDisplayed();
		System.out.println("==to verify smartmedic demo=====");
		Thread.sleep(2000);
	}


	@And("^clicks on the ICU button (.*)$")
	public void clicks_on_the_icu_button_ic_uname(String ICUname) throws InterruptedException {	
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


	}

	@Then("user navigate to pediatricICU page")
	public void user_navigate_to_pediatric_icu_page() {
		Cardio.checkpediatricICUisDisplayed();
		driver.close();
		driver.quit();	
	}

	//Selecting bed

	@Then("^user click on the button (.*)$")
	public void user_click_on_the_button_cardiac_icu(String ICUname) throws InterruptedException {
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

		//		List<WebElement> getpatient = driver.findElements(By.className("patienticon")); 
		//	int getp = getpatient.size();
		//		System.out.println("==number of the patient in thee bed ======="+getp);
		//		
		//		
		//		List<WebElement> gettotal = driver.findElements(By.className("//div[@class='icustatus']//li")); 
		//		int gett = gettotal.size();
		//		System.out.println("==number of the patient in thee bed ======="+gett);
	//		
	//		
		//		
		//		
	//		
	//		
		//		
		//		
	//		
	}
//	//
//	//
//	//
	@Then("^user click on the Bed No.(.*)$")
	public void user_click_on_the_bed_no(String bno) throws InterruptedException {


		List <WebElement> bedlist = driver.findElements(By.xpath("//div[@class='bednumber']"));

		for(WebElement bedno : bedlist)
		{
			String Bednumber=bedno.getText();
			System.out.println(Bednumber);
			System.out.println(bno);

			if(Bednumber.equals(bno)) {
				bedno.click();
				Thread.sleep(3000);
				break;
			}
		}

	}
	@Then("two section is visible if there is weight")
	public void two_section_is_visible_if_there_is_weight() throws InterruptedException {

		if(driver.getPageSource().contains("Bed No. 002"))
		{
			System.out.println("Bed no. is diaplayed");
		}
		if(driver.getPageSource().contains("Patient Weight Trend"))
		{
			System.out.println("====Pateint Weight Trend is displayed=====");
		}
		if(driver.getPageSource().contains("Patient Turn Log"))
		{
			System.out.println("====Pateint Trun Log is displayed=====");
		}

		Thread.sleep(3000);



		CardiacICUpage Cardio =  new CardiacICUpage(driver);
		String graph = Cardio.verifysvggraphforpediatricisDisplayed().getAttribute("id");
		System.out.println("===The id of the graph is="+graph);

		//======Verifying the print button==========

		List <WebElement> printlist = driver.findElements(By.xpath("//div[@class='printExport']/button[1]"));

		for(WebElement printno : printlist)
		{
			String printname=printno.getText();
			System.out.println(printname);
			int printcount=printlist.size();
			System.out.println(printcount);

		}

		//=====Verifying the export button========

		List <WebElement> exportlist = driver.findElements(By.xpath("//div[@class='printExport']/button[2]"));

		for(WebElement exportno : exportlist)
		{
			String exportname=exportno.getText();
			System.out.println(exportname);
			int exportcount=exportlist.size();
			System.out.println(exportcount);

		}

		driver.close();
		driver.quit();
	}
	
	@And("^click the ICU button (.*)$")
	public void click_the_icu_button_ic_uname(String ICUname) throws InterruptedException {
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
	}



	@And("user click on the cardiacICU from the dropdown list")
	public void user_click_on_the_cardiac_icu_from_the_dropdown_list() throws InterruptedException {
		//selecting cardiac value from the drop down
//		
//		
		  driver.findElement(By.xpath("//div[@class='addBedSelect css-2b097c-container']")).click();
//		 // driver.findElement(By.xpath("//div[@class=' css-175etaj-menu']//li[text(),'Cardiac ICU']")).click();
		  List <WebElement> droplist = driver.findElements(By.xpath("//div[@class=' css-175etaj-menu']"));
		  System.out.println(droplist.size());
		  
		
		  
		  for(int i=0;i<droplist.size();i++){
			 
			  System.out.println(droplist.get(i).getText());
			  if(droplist.get(i).getText().contains("Cardiac ICU"))
			  {
				 
				  System.out.println("======verified");
				  System.out.println(droplist.get(i).getText());
				  droplist.get(i).click();
				  break;
			  }
		  }
		  }
		  
		  
  
		  
	
	@Then("user naviagtes to the cardiacICU screen")
	public void user_naviagtes_to_the_cardiac_icu_screen() {
		driver.close();
		driver.quit();
		
	}

	@Then("^press on the ICU button (.*)$")
	public void press_on_the_icu_button_ic_uname(String ICUname) throws InterruptedException {
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
	}


	@Then("click on the signout button from the drop down list")
	public void click_on_the_signout_button_from_the_drop_down_list() {
		
		driver.findElement(By.xpath("//*[name()='svg']//*[local-name()='path' and @d='M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z']")).click();
	  
	  List <WebElement> menulist = driver.findElements(By.xpath("//div[@class='settingDrodown sdOpen']//a"));
		  System.out.println(menulist.size());
		  
		
		  
		  for(int i=0;i<menulist.size();i++){
			 
			  System.out.println(menulist.get(i).getText());
			  if(menulist.get(i).getText().contains("Sign out"))
			  {
				 
				  
				 menulist.get(i).click();
				  break;
			  }
		  }
	}
	@Then("navigate to login screen")
	public void navigate_to_login_screen() {
		if(driver.getPageSource().contains("Hospital Code"))
		{
			System.out.println("hospital code is displayed");
		}
		driver.close();
		driver.quit();
	}




}


