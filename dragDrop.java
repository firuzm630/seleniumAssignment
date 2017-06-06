import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop 
{
public static void main(String[] args)
{
WebDriver driver=new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("http://www.dhtmlgoodies.com/submitted...");
String xp1="//h1[text()='Block 1']";
WebElement source = driver.findElement(By.xpath(xp1));
String xp2="//h1[text()='Block 3']";
WebElement target = driver.findElement(By.xpath(xp2));
Actions actions=new Actions(driver);
actions.dragAndDrop(source, target).perform();
}

}