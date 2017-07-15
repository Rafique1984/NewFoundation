package tests;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utils.ExcelDataConfig;
import utils.SendEmail;

public class TestSigninPage extends TestBase {
	@BeforeClass
	public void classSetUp() {
		menuBar.signinLink.click();
	}

	@BeforeMethod
	public void print() {
		System.out.println("----------- Test Start -----------");
	}

	@Test(dataProvider = "elitecareerData")
	public void signinPage(String UserName, String Password) throws InterruptedException {
		driver.findElement(By.linkText("Signin")).click();
		driver.findElement(By.name("Email")).sendKeys(UserName);
		driver.findElement(By.name("Password")).sendKeys(String.valueOf(Password));
		driver.findElement(By.name("submit")).click();

		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		Assert.assertEquals("Hi, Muhammad Khalil", "Hi, Muhammad Khalil");
		// Assert.assertTrue(driver.getTitle().contains("Hi, Nizamul Hayder"));
		Assert.assertTrue(signin.getCurrentUrl().contains("/profile"));

		menuBar.logoutLink.click();
		menuBar.signinLink.click();

	}

	@AfterMethod
	public void MethodEnd(ITestResult result) throws EmailException {

		if (result.getStatus() == ITestResult.FAILURE) {
		}
		SendEmail.sendEmailNotification();
	}

	@AfterClass
	public void classTeardown() throws EmailException {
		menuBar.jobSearchLink.click();
	}

	@DataProvider(name = "elitecareerData")

	public Object[][] passData() {
		String filePath = "/Users/mohammadislam/Documents/workspace/NewFoundation/src/main/resources/properties/ExcelData.xlsx";
		ExcelDataConfig configer = new ExcelDataConfig(filePath);
		// Change Sheet Number here.
		int rows = configer.getRowCount(0);
		Object[][] data = new Object[rows][2];
		// data[0][0] = configer.getData(0, 0, 0);
		// data[0][1] = configer.getData(0, 0, 1);

		for (int i = 0; i < rows; i++) {
			data[i][0] = configer.getData(0, i, 0);
			data[i][1] = configer.getData(0, i, 1);
		}
		// for (int j = 0; j < rows; j++) {
		// data[j][0] = configer.getData(0, j, 1);
		//
		// }
		return data;
	}
}