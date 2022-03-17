package pageobj;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class Testcases extends Base {


     
	  @Test	
	  public void login() {
		 
		 PageFactory.initElements(driver, Pagewebelements.class);
		 
		 Pagewebelements.username.sendKeys(properties.getProperty("user"));
		 Pagewebelements.password.sendKeys(properties.getProperty("pass"));
		 Pagewebelements.login.click();
	 
	 }
    
}

			
		
