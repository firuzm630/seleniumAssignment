package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropBoxMultipleDownload {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.dropbox.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDropBoxMultipleDownload() throws Exception {
    driver.get(baseUrl + "/?landing=sign_up_for_team_exp");
    driver.findElement(By.id("sign-in")).click();
    driver.findElement(By.id("pyxl3906470684862733722")).clear();
    driver.findElement(By.id("pyxl3906470684862733722")).sendKeys("firuzm614@gmail.com");
    driver.findElement(By.id("pyxl3906470684862733725")).clear();
    driver.findElement(By.id("pyxl3906470684862733725")).sendKeys("fiko19111");
    driver.findElement(By.cssSelector("button.login-button.button-primary")).click();
    driver.findElement(By.xpath("//div[@id='component7392963614410496918']/div/main/div/div/div/div[2]/ul/li[2]/div[8]/div/div/button")).click();
    driver.findElement(By.xpath("//img[@alt='Close']")).click();
    driver.findElement(By.xpath("//img[@alt='Close']")).click();
    driver.findElement(By.cssSelector("button.checkbox-button.checked")).click();
    driver.findElement(By.xpath("//div[@id='component7392963614410496918']/div/main/div/div/div/div[2]/ul/li[3]/div/button")).click();
    driver.findElement(By.xpath("//div[@id='component7392963614410496918']/div/main/div[2]/div/div/div[2]/div/div/button")).click();
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
