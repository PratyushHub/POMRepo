package component_lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class search_cart {
	public WebDriver driver;
	@FindBy(id="twotabsearchtextbox")
	public WebElement search_txt;
	@FindBy(xpath="//*[@class='nav-input'][@value='Go']")
	public WebElement search_btn;
	
	public search_cart(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void Enter_Searchtxt(String Value)
	{
		
		search_txt.sendKeys(Value+ "\n");
		
	}
	public void Click_Searchbtn()
	{
		search_btn.click();
		
	}

	
}
