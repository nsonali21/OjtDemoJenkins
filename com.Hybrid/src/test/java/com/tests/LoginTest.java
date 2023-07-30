package com.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class LoginTest extends BaseClass{
	@BeforeSuite
	public void setup() throws Exception {
		intialization();
		reportInit();
	}
	@Test
	public void test_01() {
	Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");//passed test case
	}
	
	@Test
	public void test_02() {//failed test case
		Assert.assertTrue(false);
	}
	@Test
	public void test_03() {//Skipped test case
		throw new SkipException("Skipping test case");
	}
}
