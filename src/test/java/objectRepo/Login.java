package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	public Login() {
    }
	public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);        
    }
	
	@FindBy(id = "exampleInputEmail1")
	private WebElement Email;
	@FindBy(id = "exampleInputPassword1")
	private WebElement Password;
	@FindBy(xpath = "//button[text()='LOG IN']")
	private WebElement LoginBtn;
	
	public void loginUser() {
		Email.sendKeys("bbhpanda681@gmail.com");
		Password.sendKeys("Bibhu@123");
		LoginBtn.click();
	}
	
}
