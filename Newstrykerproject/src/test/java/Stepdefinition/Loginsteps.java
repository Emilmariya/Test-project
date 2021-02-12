package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

import Pages.Login;
import io.cucumber.java.en.*;

public class Loginsteps {

	public WebDriver driver;
	Login log;
	
	@Given("user on browser")
	public void user_on_browser() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");   
		driver = new ChromeDriver();
	}
	

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@And("^user enters (.*)$")
	public void user_enters(String hospitalcode) {
		log=new Login(driver);
		log.enterhospitalcode(hospitalcode);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		
		log.clickOnProceedButton();
	}

	@Then("user is navigate to stryker home page")
	public void user_is_navigate_to_stryker_home_page() {
		
		System.out.println("====verify=======");
		
		if(driver.getPageSource().contains("Invalid hospital code")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
		String actualTitle = driver.getTitle();
		String expectedTitle = "NSA";
		AssertJUnit.assertEquals(expectedTitle,actualTitle);
		
		}
		
		driver.close();
		driver.quit();
		
	}

	//to check error message
	
	@When("clicks on proceed button")
	public void clicks_on_proceed_button() {
		System.out.println("===to verify 'Please enter hospiatal code'======");
		driver.findElement(By.xpath("//button[@class='loginbtn']")).sendKeys(Keys.ENTER);
		//log.clickOnProceedButton();
	}



	@Then("user view error message {string}")
	public void user_view_error_message(String msg) {
		
	Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Please enter hospital code')]")).getText().contains("Please enter hospital code"));
	System.out.println("=======verified======");	
	driver.close();
		driver.quit();
	}
	
}
