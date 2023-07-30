package com.base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilites.PropertyUtils;

public class BaseClass {

	public static WebDriver driver=null;
	public static ExtentReports report=null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	public static Logger log = Logger.getLogger(BaseClass.class);
	
	
	
	public static void intialization() throws IOException {
		
		System.out.println("browser intializing");//only console
		log.info("browser initializing");//console as wel as in file with time,line no,class
		String browserName=PropertyUtils.readProperties("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/TestData/chromedriver.exe");
		    driver=new ChromeDriver();
		}
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/TestData/geckodriver.exe");//didnt added this driver so if u wnt use the dwnload it
		    driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get("file:///C:/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	}
	
	public void reportInit() {
		report=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		report.attachReporter(spark);
	}
}
