package objectRepo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.ExcelUtils;

public class CreateEventPage {
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	ExcelUtils excel = new ExcelUtils(projectPath+"/data/testData.xlsx","Event");
	public CreateEventPage() {
    }
	public CreateEventPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);        
    }
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	@FindBy(id = "eventTitle")
	private WebElement EventTitle;
	@FindBy(id = "tinymce")
	private WebElement Description;
	@FindBy(xpath   = "//*[text()='Select a Category']")
	private WebElement category;
	@FindBy(xpath = "(//ul[@class='dropdown-menu categorySelect']/li[@onclick])[1]")
	private WebElement categoryOption;
	@FindBy(id  = "subCategoryName")
	private WebElement SubCategory;
	@FindBy(id = "eventUrl")
	private WebElement eventURL;
	@FindBy(xpath = "(//Input[@placeholder='Enter a tag'])[2]")
	private WebElement Tag;
	@FindBy(xpath = "(//Input[@placeholder='Enter a location'])")
	private WebElement Location;
	@FindBy(id = "eventAddress1")
	private WebElement Address1;
	@FindBy(id = "eventAddress2")
	private WebElement Address2;
	@FindBy(id = "country")
	private WebElement Country;
	@FindBy(id = "state")
	private WebElement State;
	@FindBy(id = "city")
	private WebElement City;
	@FindBy(id = "pincode")
	private WebElement Pincode;
	@FindBy(id = "start_date")
	private WebElement StartDate;
	@FindBy(id = "end_date")
	private WebElement EndDate;
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement Nextbtn;
	@FindBy(id = "ticketName0")
	private WebElement TicketName;
	@FindBy(id = "price0")
	private WebElement Price;
	@FindBy(id = "golive")
	private WebElement GoLiveBtn;
	@FindBy(xpath = "//a[contains(@class,'showeventbox preview')]")
	private WebElement title;

	
	
	
	public void cevent() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String EventName =null;
		String Descriptiondetails = null;
		String SubCategorys = null;
		String Tags = null;
		String Venue = null;
		String AddressLine1 = null;
		String AddressLine2 = null;
		String Countryname = null;
		String Statename = null;
		String Cityname = null;
		String Pincode_pin = null;
		String Ticket_Name = null;
		String url = "wwww."+getSaltString() + ".com";
		String TPrice = null;
		try {
			EventName = ExcelUtils.getData(1,0);
			EventTitle.sendKeys(EventName);
			driver.switchTo().frame("event-desc_ifr");
			Descriptiondetails = ExcelUtils.getData(1,1);
			Description.sendKeys(Descriptiondetails);
			driver.switchTo().defaultContent();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", category);
			Thread.sleep(5000);
			category.click();
			categoryOption.click();
			SubCategorys = ExcelUtils.getData(1, 2);
			SubCategory.sendKeys(SubCategorys);
			eventURL.clear();
			eventURL.sendKeys(url);
			Tags = ExcelUtils.getData(1,3);
			Tag.sendKeys(Tags);
			Venue = ExcelUtils.getData(1,4);
			Location.sendKeys(Venue);
			Location.sendKeys(Keys.RETURN);
			AddressLine1 = ExcelUtils.getData(1,5);
			Address1.sendKeys(AddressLine1);
			AddressLine2 = ExcelUtils.getData(1,6);
			Address2.sendKeys(AddressLine2);
			Countryname = ExcelUtils.getData(1,7);
			Country.sendKeys(Countryname);
			Statename = ExcelUtils.getData(1,8);
			State.sendKeys(Statename);
			Cityname = ExcelUtils.getData(1,9);
			City.sendKeys(Cityname);
			double pin_value = excel.getNumericData(1,10);
			Pincode_pin = String.format ("%.0f", pin_value);
			Pincode.sendKeys(Pincode_pin);
//			Selecting Start date and Date
			StartDate.click();
			Nextbtn.click();
			driver.findElement(By.xpath("//a[text()='1']")).click();
			EndDate.click();
			Nextbtn.click();
			driver.findElement(By.xpath("//a[text()='28']")).click();
			Ticket_Name = ExcelUtils.getData(1,11);
			TicketName.sendKeys(Ticket_Name);
			Pincode.clear();
			double price_value = excel.getNumericData(1,12);
			TPrice = String.format ("%.0f", price_value);
			Price.sendKeys(TPrice);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", GoLiveBtn);
			GoLiveBtn.click();			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		String ActualResult = driver.findElement(By.xpath("//a[@title="+EventName+"]")).getAttribute("title");
		System.out.println(ActualResult);
		Assert.assertEquals(ActualResult, EventName);
		
		
		
		
		//Description.sendKeys("aczcac");
	}


}
