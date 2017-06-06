package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase1 {
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
  public void testCase1() throws Exception {
    driver.get(baseUrl + "/index.php");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email_create")).click();
    driver.findElement(By.id("email_create")).clear();
    driver.findElement(By.id("email_create")).sendKeys("firuzm630@gmail.com");
    driver.findElement(By.id("SubmitCreate")).click();
    driver.findElement(By.id("id_gender1")).click();
    driver.findElement(By.id("customer_firstname")).clear();
    driver.findElement(By.id("customer_firstname")).sendKeys("Firuz");
    driver.findElement(By.id("customer_lastname")).clear();
    driver.findElement(By.id("customer_lastname")).sendKeys("Mammadov");
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys("fikofiko");
    new Select(driver.findElement(By.id("days"))).selectByVisibleText("regexp:23\\s+");
    driver.findElement(By.cssSelector("option[value=\"23\"]")).click();
    new Select(driver.findElement(By.id("months"))).selectByVisibleText("regexp:April\\s");
    driver.findElement(By.cssSelector("#months > option[value=\"4\"]")).click();
    new Select(driver.findElement(By.id("years"))).selectByVisibleText("regexp:1992\\s+");
    driver.findElement(By.cssSelector("option[value=\"1992\"]")).click();
    driver.findElement(By.id("optin")).click();
    driver.findElement(By.id("address1")).clear();
    driver.findElement(By.id("address1")).sendKeys(",Naghimihaly Ut 19.");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("Budapest");
    new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Alaska");
    driver.findElement(By.cssSelector("#id_state > option[value=\"2\"]")).click();
    driver.findElement(By.id("postcode")).clear();
    driver.findElement(By.id("postcode")).sendKeys("501");
    driver.findElement(By.id("phone_mobile")).clear();
    driver.findElement(By.id("phone_mobile")).sendKeys("+994558586512");
    driver.findElement(By.id("submitAccount")).click();
    driver.findElement(By.id("postcode")).clear();
    driver.findElement(By.id("postcode")).sendKeys("50100");
    driver.findElement(By.id("submitAccount")).click();
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys("fikofiko");
    driver.findElement(By.id("submitAccount")).click();
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
}
