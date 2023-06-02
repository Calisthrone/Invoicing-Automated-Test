package PageSuperclass;

import Identities.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public static double actualInvoiceValue; // actual invoice value (calculated from web)
    public static double expectedInvoiceValue; // expected invoice value (calculated from DB)
    public static List<Item> allStoredItemsList; // all items stored in DB.

    public static WebDriver driver;
    public BasePage(WebDriver driver) {BasePage.driver = driver;}

    public static WebDriver getDriver() {return driver;}

    // Wait For Element To Appear
    public void waitForVisibilityOf(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
