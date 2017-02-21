package component_lib;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import config_lib.TestDriver;

public class search_item extends TestDriver {
	static Logger log= Logger.getLogger(search_item.class);
	SoftAssert SAssert= new SoftAssert();
	
	@Test
	public void validSearch() throws IOException{
		startBrowser();
		search_cart cart = new search_cart(driver);
		cart.Enter_Searchtxt("Mobile");
		log.info("Search for Mobile");
		cart.Click_Searchbtn();
		log.info("Click on search button");
	}
}
