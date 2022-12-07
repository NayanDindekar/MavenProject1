package MavenPOMClassesNeoStox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import MavenUtilityClassesNeoStox.MavenNeoStoxUtilityClass;

public class MavenNeoStoxSignINPagePOM 
{
	@FindBy (id = "MainContent_signinsignup_txt_mobilenumber") private WebElement NDMobNum;
	@FindBy (xpath = "(//a[text()='Sign In'])[2]") private WebElement NDSignInButton;
	
	public MavenNeoStoxSignINPagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void NDEnterMobNum(WebDriver driver, String MOB)
	{
		MavenNeoStoxUtilityClass.ImplicitWait(driver, 5000);
		NDMobNum.sendKeys(MOB);
		Reporter.log("Entering Mobile Number", true);
	}
	public void NDClickOnSignInButton()
	{
		NDSignInButton.click();
		Reporter.log("Clicking On Sign In Button and Move Towards Password Page", true);
	}

}
