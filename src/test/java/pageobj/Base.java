package pageobj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit; 


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;





public class Base {


	public static WebDriver driver=null;
	public  static Properties properties=null;
	public  static ExtentReports extent;
	public  static ExtentSparkReporter spark;
	public  static ExtentTest test;





	public Properties loadPropertyFile() throws IOException {
		FileInputStream fileinputstream=new FileInputStream("D:\\Eclipse-Workspaces\\jee-2021-03\\aruna\\src\\test\\java\\pageobj\\config.properties");
		properties =new Properties();
		properties.load(fileinputstream);
		return properties;
	}




	@BeforeSuite
	public void LaunchBrowser() throws IOException {


		// addin comment or Git
		extent=new ExtentReports();
		spark=new ExtentSparkReporter("indx.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Aruna Report");
		spark.config().setReportName("hrm login report");
		extent.attachReporter(spark);

		ExtentTest test=extent.createTest("verifylogin");
		test.pass("login testcase started");
		test.log(Status.INFO, "Navigating to goole");

		loadPropertyFile();
		String browser1=properties.getProperty("browser");
		String url1=properties.getProperty("url");
		String driverlocation=properties.getProperty("driverLocate");

		if(browser1.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverlocation);
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();

		driver.get(url1);

		String title=driver.getTitle();
		test.log(Status.INFO, "Actual title" +title);
		test.log(Status.INFO,"expected title" +"Google");
		test.log(Status.INFO,"verifying of actual and expect title" );
		if(title.equals("Google")) {
			test.log(Status.PASS, " Both titles matched");
		}
		else {
			test.log(Status.FAIL,"Both titles are not matched");
			TakesScreenshot screenshot=(TakesScreenshot) driver;
			File source=screenshot.getScreenshotAs(OutputType.FILE);
			File des=new File("login.png");
			FileHandler.copy(source, des);
			test.addScreenCaptureFromPath("login.png");
			
		}


	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}



	@AfterSuite
	public void CloseBrowser(){

		//driver.quit();
		extent.flush();

	}
}



