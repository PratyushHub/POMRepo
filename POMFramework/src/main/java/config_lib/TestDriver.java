package config_lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.server.browserlaunchers.FirefoxChromeLauncher;

import component_lib.search_item;

public class TestDriver {
  public static WebDriver driver = null;
  static Logger log= Logger.getLogger(TestDriver.class);
  
  public Properties loadProperty() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\ConfigProperty\\Config.properties");
		Properties pro=new Properties();
		pro.load(fis);
		return pro;
	}
	public void startBrowser() throws IOException{
		Properties pr=loadProperty();
		String browser = pr.getProperty("browser");
		System.out.println(browser);
		log.info("Selecting the browser");
		if(browser.equals("firefox")){
			driver = new FirefoxDriver();
			log.info("Firefox selected ");
		}else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pratyush\\Desktop\\TriNet Analysis\\NewWorkSpace\\POMFramework\\Lib\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome browser selected");
		}else if(browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Pratyush\\Desktop\\TriNet Analysis\\NewWorkSpace\\POMFramework\\Lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.info("IE browser selected");
	    }
		driver.get(pr.getProperty("url"));
		driver.manage().window().maximize();
		}
	
	
}
