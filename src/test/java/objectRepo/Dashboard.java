package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	WebDriver driver = null;
//	String projectPath = System.getProperty("user.dir");
	public Dashboard() {
    }
	public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);        
    }
	
	@FindBy(xpath = "//a[text()='Create Event']")
	private WebElement CreateEvent;
	
	public void navigateToEvent() {
		CreateEvent.click();
	}

}
