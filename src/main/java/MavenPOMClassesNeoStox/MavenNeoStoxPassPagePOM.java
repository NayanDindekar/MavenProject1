package MavenPOMClassesNeoStox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import MavenUtilityClassesNeoStox.MavenNeoStoxUtilityClass;

public class MavenNeoStoxPassPagePOM 
{
	@FindBy (id = "txt_accesspin") private WebElement NDPass;
	@FindBy (xpath = "//a[text()='Submit']") private WebElement NDSubmitButton;
	
	public MavenNeoStoxPassPagePOM (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void NDEnterPass(WebDriver driver, String PWD)
	{
		MavenNeoStoxUtilityClass.ImplicitWait(driver, 5000);
		NDPass.sendKeys(PWD);
		Reporter.log("Entering Password", true);
	}
	public void NDClickOnSubmitButton() throws InterruptedException
	{
		Thread.sleep(2000);
		NDSubmitButton.click();
		Reporter.log("Clicking On Submit Button and Move Towards Home Page", true);
	}
}
