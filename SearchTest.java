package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

/**
 * Created by Firuz on 6/6/2017.
 */

public class SearchTest {

    private Search page;

    @Before
    public void openTheBrowser() {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromeDriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");


        page = PageFactory.initElements(new ChromeDriver(options), EbaySearch.class);
        page.open("http://ebay.com/");
    }


    @Test
    public void whenTheUserSearchesForSeleniumTheResultPageTitleShouldContainCats() {
        page.searchFor("get input value");

        assertThat(page.getTitle(), containsString("get input value") );
    }
}