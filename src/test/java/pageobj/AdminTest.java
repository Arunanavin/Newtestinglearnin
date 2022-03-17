package pageobj;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AdminTest extends Base {
	@Test
	public void admin() throws IOException {
		PageFactory.initElements(driver,Adminwebelemnts.class);
		Actions actions=new Actions(driver);
		actions.moveToElement(Adminwebelemnts.admintab);
		actions.moveToElement(Adminwebelemnts.usermanage);
		actions.moveToElement(Adminwebelemnts.user);
		actions.click().build().perform();
		
		ExtentTest test=extent.createTest("verifyadmin");
		test.pass("admin testcase started");
		test.log(Status.INFO, "Navigating to goole");
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		File des=new File("admin.png");
		FileHandler.copy(source, des);
		test.addScreenCaptureFromPath("admin.png");
		
		
	}
	

}
