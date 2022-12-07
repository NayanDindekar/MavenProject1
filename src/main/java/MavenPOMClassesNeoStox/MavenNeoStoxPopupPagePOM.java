package MavenPOMClassesNeoStox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import MavenUtilityClassesNeoStox.MavenNeoStoxUtilityClass;

public class MavenNeoStoxPopupPagePOM 
{
	@FindBy (xpath = "//*[@id=\"modal_neostoxinfo\"]/div/div/div[3]/div/div/div/a") private WebElement NDOkButton;
	@FindBy (xpath = "//*[@id=\"modal_buyplans\"]/div/div/div/div/div/div[7]/a") private WebElement NDCloseButton;
	
	public MavenNeoStoxPopupPagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void NDClickOnOkButton(WebDriver driver) throws InterruptedException
	{
//		MavenNeoStoxUtilityClass.ImplicitWait(driver, 10000);
		Thread.sleep(5000);
		NDOkButton.click();
		Reporter.log("Clicking On OK Button", true);
	}
	public void NDClickOnCloseButton(WebDriver driver) throws InterruptedException
	{
//		MavenNeoStoxUtilityClass.ImplicitWait(driver, 5000);
		Thread.sleep(2000);
		NDCloseButton.click();
		Reporter.log("Clicking On Close Button", true);
	}

}
