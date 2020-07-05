package framework.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.utils.BrowserUtil;

public class BasePage {
	
	
	private static final Logger log = Logger.getLogger(BasePage.class);
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public String appURL;
	public Properties prop = new Properties();

	
	public BasePage(WebDriver driver) {
		log.info("BasePage(WebDriver driver) is invoked");
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		BrowserUtil.driver = this.driver;
		BrowserUtil.wait = this.wait;
		
		
        try (InputStream input = new FileInputStream("/Users/thinker/training/ecommerce/src/main/resources/config.properties")) {

            // load a properties file
            prop.load(input);
            appURL = prop.getProperty("url");
            

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        PageFactory.initElements(driver, this);
        
		log.info("BasePage(WebDriver driver) is completed");
	}
	
	
	public BasePage() {
		log.info("BasePage() is invoked and there is nothing logic to handle here");
		// TODO Auto-generated constructor stub
	}
	
	//App page or home page...as the user of the application, you will search something from home page
	//menu page
	
	
	
	

}
