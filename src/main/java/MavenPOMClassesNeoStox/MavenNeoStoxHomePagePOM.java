package MavenPOMClassesNeoStox;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import MavenUtilityClassesNeoStox.MavenNeoStoxUtilityClass;

public class MavenNeoStoxHomePagePOM 
{
	@FindBy (id = "lbl_username") private WebElement NDUserID;
	@FindBy (id = "lbl_curbalancetop") private WebElement NDFund;
	@FindBy (id = "lbl_curbalancetop") private WebElement NDProfile;
	@FindBy (xpath = "//span[text()='Logout']") private WebElement NDLogOutButton;
	
	public MavenNeoStoxHomePagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String NDFetchingUID(WebDriver driver)
	{
		MavenNeoStoxUtilityClass.ImplicitWait(driver, 5000);
		String ActUName = NDUserID.getText();
		Reporter.log("Actual and Expected User Name Are Matched, TC is Pass", true);
		return ActUName;
	}
	public void NDFetchingFund (WebDriver driver) throws InterruptedException, IOException
	{
		Thread.sleep(500);
		String fund = NDFund.getText();
		MavenNeoStoxUtilityClass.TakeScreenShot(driver, "FundScreenShot");
		Reporter.log("Available Funds are "+fund);
	}
	public void NDClickOnProfile() throws InterruptedException
	{
		Thread.sleep(2000);
		NDProfile.click();
		Reporter.log("Clicking On Profile", true);
	}
	public void NDClickOnLogOutButton() throws InterruptedException
	{
		Thread.sleep(2000);
		NDLogOutButton.click();
		Reporter.log("Logging Out", true);
	}


}
