package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import framework.BasePage;

public class HomePage extends BasePage {
	
	private static final Logger log = Logger.getLogger(HomePage.class);
	
	public HomePage(WebDriver driver) {
		super(driver);
		log.info("Home page constructor is invoked");
		PageFactory.initElements(driver, this);
		log.info("Home page objects are initialized successfully and constructor ends");
	}
	
	public void launchApp(String url) {
		log.info("launchApp(String url) is invoked");
		driver.get(url);
		log.info("launchApp(String url) is completed");

	}

}
