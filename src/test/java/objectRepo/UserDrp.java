package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDrp {
	WebDriver driver = null;
//	String projectPath = System.getProperty("user.dir");
	public UserDrp() {
    }
	public UserDrp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);        
    }
	
	@FindBy(id = "user-toggle")
	private WebElement UserToggle;
	@FindBy(xpath = "//*[contains(text(),' Logout')]")
	private WebElement Logout;
	
	public void LogoutUser() throws InterruptedException {
		UserToggle.click();
		Thread.sleep(2000);
		Logout.click();
	}

}
