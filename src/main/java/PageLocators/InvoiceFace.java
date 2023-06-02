package PageLocators;

import org.openqa.selenium.By;

public interface InvoiceFace {

    String invoicePageUrlPrefix = "https://www.example.com/invoice/";

    String singleItemLocator = "some locator";
    By itemsContainerLocator = By.cssSelector("some locator");

}
