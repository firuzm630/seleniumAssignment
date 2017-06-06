package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc3 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Firuz-PC\\Desktop\\testingSoftware\\assign2\\dev\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://automationpractice.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTc3() throws Exception {
    driver.get(baseUrl + "/index.php");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("firuzm630@gmail.com");
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys("fikofiko");
    driver.findElement(By.id("SubmitLogin")).click();
    driver.findElement(By.linkText("Contact us")).click();
    new Select(driver.findElement(By.id("id_contact"))).selectByVisibleText("Customer service");
    driver.findElement(By.cssSelector("option[value=\"2\"]")).click();
    driver.findElement(By.id("fileUpload")).clear();
    driver.findElement(By.id("fileUpload")).sendKeys("C:\\Users\\Firuz-PC\\Desktop\\gg.PNG");
    driver.findElement(By.id("message")).clear();
    driver.findElement(By.id("message")).sendKeys("it is test");
    driver.findElement(By.id("submitMessage")).click();
    driver.findElement(By.linkText("Sign out")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  private boolean addCookie (){
	  Cookie ck = new Cookie("name", "value");
      driver.manage().addCookie(ck);
	  if (ck.getName().equals("name")){
		  return true;
	  }else
		  return false;
	  return false;
  }
}
