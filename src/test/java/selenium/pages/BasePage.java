package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    private static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void sendKey(By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(text);
    }

    public static void clickOnElement(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public static String getValue(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator).getText();
    }

    private static WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void selectElement(By locator, String value) {
        Select dropdownFromAccountId = new Select(waitForElement(locator));
        dropdownFromAccountId.selectByVisibleText(value);
    }

    public static void openUrl(String url) {
        driver.get(url);
    }

}
