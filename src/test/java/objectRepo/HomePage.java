package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utils.ExcelUtils;

public class HomePage {
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
//	ExcelUtils excel = new ExcelUtils(projectPath+"/data\\testData.xlsx","CreatePass");

	public HomePage() {
    }
	public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);        
    }
	@FindBy(xpath = "//a[text()='Log In']")
	private WebElement Login;
	
	public void login() {
		Login.click();
	}

}
