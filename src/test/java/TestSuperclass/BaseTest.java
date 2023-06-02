package TestSuperclass;

import PageObjects.InvoicePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public static WebDriver driver;
    public static InvoicePage invoicePage;

    @BeforeTest
    public void setupDriver() {
        // initialize the driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // initialize page objects
        invoicePage = new InvoicePage(driver);
    }
}
