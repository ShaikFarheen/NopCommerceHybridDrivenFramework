package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;//logging
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;//for logging
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Master","Regression","Sanity"})
	@Parameters("browser")
	public void setUp(String br) {
		rb=ResourceBundle.getBundle("config");//load config.properties file
		logger=LogManager.getLogger(this.getClass());// this.getClass() method will send the current class which is executing to the logger files there we can see if any errors r present
		//when we run scripts in browser we can see chrome is being controlled by automated test software msg in url so to avoid that we use above 3 lines
//		ChromeOptions options=new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
//		driver=new ChromeDriver(options);
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
		driver=new EdgeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(rb.getString("appUrl"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"Master","Regression","Sanity"})
	public void tearDown() {
		driver.quit();
	}
	public String captureScreen(String tname) {
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		try {
			FileUtils.copyFile(source,new File(destination));
		}catch(Exception e) {
			e.getMessage();
		}
		return destination;
	}
	
   
}
