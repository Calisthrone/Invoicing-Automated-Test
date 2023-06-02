package Utils;

import Identities.Item;
import PageLocators.InvoiceFace;
import PageSuperclass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utils implements InvoiceFace{

    private static final WebDriver driver = BasePage.getDriver();
    private static final BasePage basePage = new BasePage(driver);

    // this method will return all stored items from DB.
    public static List<Item> getAllStoredItems() {
        // some code to extract all items form DB.
        return new ArrayList<>();
    }

    // get the total expected invoice value.
    public static double getExpectedInvoiceValue() {
        double totalExpectedPrice = 0.00;

        for (int i = 1; i <= getInvoiceItemsCount(); i ++) {
            String itemSku = driver.findElement(By.xpath(
                    singleItemLocator + "[" + i + "]"))
                    .getAttribute("item-sku");

            for (Item storedItem : BasePage.allStoredItemsList) {
                if (Objects.equals(storedItem.sku(), itemSku)) {
                    totalExpectedPrice = totalExpectedPrice + storedItem.price();
                }
            }
        }
        return totalExpectedPrice;
    }

    // This method will return the actual total amount of an invoice
    // This method can calculate with or without discounts / vats
    public static double getActualInvoiceValue(boolean discount, double discountPercentage
            , boolean vat, double vatPercentage) {

        double[] invoiceItems = new double[getInvoiceItemsCount()];
        double finalValue = 0.00;

        for (int i = 1; i <= getInvoiceItemsCount(); i ++) {
            invoiceItems[i] = Double.parseDouble(driver
                    .findElement(By.xpath(singleItemLocator + "[" + i + "]"))
                    .getAttribute("textContent"));
        }

        for (double itemPrice : invoiceItems) {
            finalValue = finalValue + itemPrice;
        }

        // apply discount if any.
        if (discount) {
            double discountAmount = finalValue * discountPercentage / 100;
            finalValue = finalValue - discountAmount;
        }

        // apply vat after making the discount.
        if (vat) {
            double vatAmount = finalValue * vatPercentage / 100;
            finalValue = finalValue + vatAmount;
        }
        return finalValue;
    }

    // get the number of items in an invoice
    private static int getInvoiceItemsCount() {
        basePage.waitForVisibilityOf(itemsContainerLocator);
        List<WebElement> itemsLinks = driver.findElements(itemsContainerLocator);
        return itemsLinks.size();
    }
}
