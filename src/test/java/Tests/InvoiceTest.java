package Tests;

import PageSuperclass.BasePage;
import TestSuperclass.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvoiceTest extends BaseTest {

    // Assert actual invoice value displayed vs. expected value of the items in the invoice.
    private void assertInvoice() {
        Assert.assertEquals(BasePage.actualInvoiceValue, BasePage.expectedInvoiceValue);
    }

    // Test Case 01 - No Discount, No Vat.
    @Test
    public void tc01_No_Discount_No_Vat(String invoiceNum) {
        invoicePage
                .gotoInvoicePage(invoiceNum)
                .getActualValue(false, 0, false, 0)
                .getExpectedValue();

        assertInvoice();
    }

    // Test Case 02 - 10% Discount, No Vat.
    @Test
    public void tc01_10_Discount_No_Vat(String invoiceNumber) {
        invoicePage
                .gotoInvoicePage(invoiceNumber)
                .getActualValue(true, 10, false, 0)
                .getExpectedValue();

        assertInvoice();
    }

    // Test Case 03 - 5% Discount, 7% Vat.
    @Test
    public void tc03_5_discount_7_vat(String invoiceNumber) {
        invoicePage
                .gotoInvoicePage(invoiceNumber)
                .getActualValue(true, 5, true, 7)
                .getExpectedValue();

        assertInvoice();
    }
}
