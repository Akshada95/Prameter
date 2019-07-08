package com.model;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MercurytsparamTest
{
  public WebDriver driver;
  
  @Parameters({"username1","password1"})
  @Test(priority=1,description="Verify that valid user able to login into Mercury Tours application by using valid username1 and password1")
  public void loginwithvalidds1(String usernm1,String passwd1) 
  {
	  System.out.println("In loginwithvalidds1 method under Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(usernm1);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwd1);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  System.out.println("Flight finder image is displayed:" +flag1);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("User1 has login into Mercury Tours successfully");
	  System.out.println("Github chnges");
  }
  
  @Parameters({"username2","password2"})
  @Test(priority=2,description="Verify that valid user able to login into Mercury Tours application by using valid username2 and password2")
  public void loginwithvalidds2(String usernm2,String passwd2) 
  {
	  System.out.println("In loginwithvalidds2 method under Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(usernm2);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwd2);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean flag2=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  System.out.println("Flight finder image is displayed:" +flag2);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("User2 has login into Mercury Tours successfully");
  }
  
  @Parameters({"username3","password3"})
  @Test(priority=3,description="Verify that valid user able to login into Mercury Tours application by using valid username3 and password3")
  public void loginwithvalidds3(String usernm3,String passwd3) 
  {
	  System.out.println("In loginwithvalidds3 method under Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(usernm3);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwd3);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean flag3=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  System.out.println("Flight finder image is displayed:" +flag3);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("User3 has login into Mercury Tours successfully");
  }
  
  @Parameters({"username4","password4"})
  @Test(priority=4,description="Verify that invalid user not able to login into Mercury tours appliction by using invalid credentials")
  public void loginwithInvalidds1(String usernm4,String passwd4) 
  {
	  System.out.println("In loginwithvalidds4 method under Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(usernm4);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwd4);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean flag4= driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
	  System.out.println("Sign on page is displayed");	  
	  
  }
  
  @Parameters({"username5","password5"})
  @Test(priority=5,description="Verify that invalid user not able to login into Mercury tours appliction by using invalid credentials2")
  public void loginwithInvalids2(String usernm5,String passwd5) 
  {
	  System.out.println("In loginwithvalidds4 method under Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(usernm5);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwd5);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean flag4= driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
	  System.out.println("Sign on page is displayed");	  
	  
  }
	  
  @BeforeMethod
  public void getAllCookies() 
  {
	  System.out.println("In getAllCookies method under BeforeMethod");
	  Set<Cookie> cookies=driver.manage().getCookies();
	  for(Cookie cookie:cookies)
	  {
		  System.out.println(cookie.getName());
	  }
  }

  
  @AfterMethod
  public void captureScreenshot() throws IOException 
  {
	  System.out.println("In captureScreenshot method under AfterMethod");
	  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("F:\\Suvidya_data\\Java_Selenium\\MercurytsparamDemo2\\Screenshots\\"));
	  System.out.println("Screenshot has captured successfully");
  }

  @BeforeClass
  public void maximizeBrowser()
  {
	  driver.manage().window().maximize();
	  System.out.println("Maximize chrome browser");
  }

  @AfterClass
  public void deleteAllCookies() 
  {
	  System.out.println("In deleteAllCookies method under AfterClass");
	  driver.manage().deleteAllCookies();
  }

  @Parameters ({"url"})
  @BeforeTest
  public void enterApplicationURL(String url) 
  {
	  System.out.println("In enterApplicationURL method under BeforeTest");
	  driver.get(url);
	  System.out.println("Application url is opened succesfully");
  }

  @AfterTest
  public void dbConnectionClosed() 
  {
	  System.out.println("In dbConnectionClosed method under AfterTest");
  }

  @Parameters ({"browser"})
  @BeforeSuite
  public void openBrowser(String browsernm) 
  {
	  System.out.println("In openBrowser method under BeforeSuite");
	  if(browsernm.equalsIgnoreCase("chrome"))
	  {
		  System.out.println("In chrome browser");
		  System.setProperty("webdriver.chrome.driver", "G:\\Selenium Setup\\setup1\\4052019\\chromedriver_win32 (21)\\chromedriver.exe");
		  driver=new ChromeDriver();
		  System.out.println("Chrome browser is opened successfully");
	  }else if(browsernm.equalsIgnoreCase("ie"))
	  {
		  System.out.println("In IE browser");
		  System.setProperty("webdriver.ie.driver", "G:\\Selenium Setup\\setup1\\4052019\\IEDriverServer_x64_3.14.0 (12)\\IEDriverServer.exe");
		  driver=new InternetExplorerDriver();
		  System.out.println("IE browser is opened successfully");
	  }else
	  {
		  System.out.println("In Mozilla Firefox browser");
		  System.setProperty("webdriver.gecko.driver", "G:\\Selenium Setup\\setup1\\4052019\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		  driver= new FirefoxDriver();
		  System.out.println("Firefox is opened successfully");
	  }
	  
  }

  @AfterSuite
  public void closeBrowser() 
  {
	  System.out.println("In closeBrowser method under AfterSuite");
	  driver.close();
  }

}
