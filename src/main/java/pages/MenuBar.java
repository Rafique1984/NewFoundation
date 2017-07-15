package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class MenuBar extends PageBase {

	 @FindBy(linkText = "Signin")
	 public WebElement signinLink;
	 
	 @FindBy(linkText = "Logout")
	 public WebElement logoutLink;
	 
	 @FindBy(linkText = "Job Search")
	 public WebElement jobSearchLink;
	
	 @FindBy(linkText = "Register")
	 public WebElement registerLink;
	
}
