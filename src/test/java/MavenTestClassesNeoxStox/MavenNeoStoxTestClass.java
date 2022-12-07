package MavenTestClassesNeoxStox;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MavenBaseClassesNeoStox.MavanNeoStoxBaseClass;
import MavenPOMClassesNeoStox.MavenNeoStoxHomePagePOM;
import MavenPOMClassesNeoStox.MavenNeoStoxPassPagePOM;
import MavenPOMClassesNeoStox.MavenNeoStoxPopupPagePOM;
import MavenPOMClassesNeoStox.MavenNeoStoxSignINPagePOM;
import MavenUtilityClassesNeoStox.MavenNeoStoxUtilityClass;

public class MavenNeoStoxTestClass extends MavanNeoStoxBaseClass 
{
	MavenNeoStoxSignINPagePOM NDSignINPage;
	MavenNeoStoxPassPagePOM NDPassPage;
	MavenNeoStoxPopupPagePOM NDPopUpPage;
	MavenNeoStoxHomePagePOM NDHomePage;
	
	@BeforeClass
	public void NDOpenBrowser() throws IOException
	{
		NDLaunchBrowser();
		NDSignINPage = new MavenNeoStoxSignINPagePOM(driver);
		NDPassPage = new MavenNeoStoxPassPagePOM(driver);
		NDPopUpPage = new MavenNeoStoxPopupPagePOM(driver);
		NDHomePage = new MavenNeoStoxHomePagePOM(driver);
	}
	@BeforeMethod
	public void NDSignIn() throws IOException, InterruptedException
	{
		NDSignINPage.NDEnterMobNum(driver, MavenNeoStoxUtilityClass.ReadDataFromPropertyFile("MobNum"));
		NDSignINPage.NDClickOnSignInButton();
		NDPassPage.NDEnterPass(driver, MavenNeoStoxUtilityClass.ReadDataFromPropertyFile("Pass"));
		NDPassPage.NDClickOnSubmitButton();
		NDPopUpPage.NDClickOnOkButton(driver);
		NDPopUpPage.NDClickOnCloseButton(driver);
	}
  @Test
  public void NDValidateUID() throws InterruptedException, IOException 
  {
	  Assert.assertEquals(NDHomePage.NDFetchingUID(driver), MavenNeoStoxUtilityClass.ReadDataFromPropertyFile("ExpUID"));
  }
  @Test
  public void NDGettingFunds() throws InterruptedException, IOException
  {
	  NDHomePage.NDFetchingFund(driver);
  }
  
  
  @AfterMethod
  public void NDLogOut() throws InterruptedException
  {
	  NDHomePage.NDClickOnProfile();
	  NDHomePage.NDClickOnLogOutButton();
  }
  @AfterClass
  public void NDCloseBrowser()
  {
	  driver.close();
  }
}
