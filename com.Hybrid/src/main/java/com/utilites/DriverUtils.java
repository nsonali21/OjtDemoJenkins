package com.utilites;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;


public class DriverUtils extends BaseClass {
	public static String captureScreenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}

}
