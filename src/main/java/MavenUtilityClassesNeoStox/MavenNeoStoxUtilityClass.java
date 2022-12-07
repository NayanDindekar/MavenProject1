package MavenUtilityClassesNeoStox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class MavenNeoStoxUtilityClass 
{
	public static void TakeScreenShot(WebDriver driver, String name) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\SOFTWARE TESTING\\ScreenShots"+name+".png");
		FileHandler.copy(src, dest);
	}
	public static void ScrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript("argument[0].scrollIntoView()", element);
	}
	public static void ImplicitWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	}
	public static String ReadDataFromPropertyFile(String Key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream myFile = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MavenPractice\\NeoStox.properties");
		prop.load(myFile);
		String values = prop.getProperty(Key);
		return values;
	}

}
