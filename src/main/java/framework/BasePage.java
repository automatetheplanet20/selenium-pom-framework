package framework;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	
	private static final Logger log = Logger.getLogger(BasePage.class);
	
	WebDriver driver;
	WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		log.info("BasePage(WebDriver driver) is invoked");
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		BrowserUtil.driver = this.driver;
		BrowserUtil.wait = this.wait;
		log.info("BasePage(WebDriver driver) is completed");
	}
	
	
	public BasePage() {
		log.info("BasePage() is invoked and there is nothing logic to handle here");
		// TODO Auto-generated constructor stub
	}
	
	//App page or home page...as the user of the application, you will search something from home page
	//menu page
	
	
	
	

}
