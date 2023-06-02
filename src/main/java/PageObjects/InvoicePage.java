package PageObjects;

import PageLocators.InvoiceFace;
import PageSuperclass.BasePage;
import Utils.Utils;
import org.openqa.selenium.WebDriver;


public class InvoicePage extends BasePage implements InvoiceFace {

    public InvoicePage(WebDriver driver) {super(driver);}

    // navigate to the invoice page according to the invoice number
    public InvoicePage gotoInvoicePage(String invoiceNumber) {
        driver.get(invoicePageUrlPrefix + invoiceNumber);
        return this;
    }

    // this method will run numerous methods (in Utils.class) and return the actual invoice value.
    public InvoicePage getActualValue(boolean discount, double discountPercentage, boolean vat, double vatPercentage) {
        actualInvoiceValue = Utils.getActualInvoiceValue(discount, discountPercentage, vat, vatPercentage);
        return this;
    }

    // this method will return the expected invoice value according to the invoice items and the stored price in DB.
    public void getExpectedValue() {
        allStoredItemsList = Utils.getAllStoredItems();
        expectedInvoiceValue = Utils.getExpectedInvoiceValue();
    }
}
