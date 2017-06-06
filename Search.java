package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search {

    protected WebDriver driver;
    private WebElement q;

    @FindBy(class="js-search-submit")
    private WebElement submit;

    public Search(WebDriver driver) {
        this.driver = driver;
    }
    public void open(String url) {
        driver.get(url);
    }
    public void close() {
        driver.quit();
    }
    public String getTitle() {
        return driver.getTitle();
    }
    public void searchFor(String searchTerm) {
        q.sendKeys(searchTerm);
        clickOnSearch();
    }
    public void typeSearchTerm(String searchTerm) {
        q.sendKeys(searchTerm);
        clickOnSearch();
    }
    public void clickOnSearch() {
        submit.click();
    }
}