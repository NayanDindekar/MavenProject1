package MavenBaseClassesNeoStox;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import MavenUtilityClassesNeoStox.MavenNeoStoxUtilityClass;



public class MavanNeoStoxBaseClass 
{
	protected WebDriver driver;
	public void NDLaunchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\SOFTWARE TESTING\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(MavenNeoStoxUtilityClass.ReadDataFromPropertyFile("url"));
	}

}
