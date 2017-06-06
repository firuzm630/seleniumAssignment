package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

import static org.omg.IOP.TAG_ORB_TYPE.value;

/**
 * This test checks sign, logout and add new address to personal data
 *
 * @author Firuz
 */
public class HoverTest {

    static WebDriver driver;
    static Wait<WebDriver> wait;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromeDriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, 30);
        driver.get("https://stackoverflow.com");

        boolean result;
        try {


            result = finalCheck();
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        } /*finally {
            driver.close();
        }*/

        System.out.println("Test " + (result? "passed." : "failed."));
        if (!result) {
            System.exit(1);
        }
    }

    


    private static void logout()
    {

        WebElement menu = driver.findElement(By.xpath("//div[@id='question-mini-list']/div[1]/div[@class='summary']/div[@class='tags']/a[@class='post-tag']"));
        Actions act = new Actions(driver); act.moveToElement(menu).perform();
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).clickAndHold();
        actions.click().build().perform();


    }


    private static boolean finalCheck() {

        return driver.findElement(By.tagName("body")).getText().contains("followers");
    }
}