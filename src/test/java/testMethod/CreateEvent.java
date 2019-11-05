package testMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRepo.CreateEventPage;
import objectRepo.Dashboard;
import objectRepo.HomePage;
import objectRepo.Login;
import objectRepo.UserDrp;

public class CreateEvent {
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait wait = null;
	HomePage home = null;
	Login login = null;
	Dashboard createEvent = null;
	CreateEventPage addEvent = null;
	UserDrp userAct = null;
  
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniuimDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		home = new HomePage(driver);
		login = new Login(driver);
		//navigate to URL
		driver.get("https://www.meraevents.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Navigate to Login screen
		home.login();
		//Login user
		login.loginUser();		
	}
	
	

  @Test
  public void CreateEvents() {
	  createEvent = new Dashboard(driver);
	  addEvent = new CreateEventPage(driver);
	  createEvent.navigateToEvent();
	  addEvent.cevent();
	  
  }
  @AfterTest
  public void close() throws InterruptedException {
	  userAct = new UserDrp(driver);
	  userAct.LogoutUser();
	  Thread.sleep(8000);
	  driver.close();
  }
}
