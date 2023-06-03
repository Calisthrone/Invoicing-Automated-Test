# Invoicing-Automated-Test
***Demonstration of how to use Automation to test invoicing platform.***

This project is built using Selenium Web Driver Framework with Java, testNG and Page Object Model.

In this project, we will mimic having an invoicing platform, and we will have 3 test cases:


1- Invoice with no discounts nor vat.

2- Invoice with 10% duscount applied.

3- Invoice with 5% duscount applied and 7% vat applied on the discounted value.


## Key Files:
- `Item`: record of item in an invoice, composed of `String sku` and `double price`.
- `InvoiceFace`: an interface for quick accessing locators and urls.
- `InvoicePage`: the page object of the invoicing UI.
- `BasePage`: the superclass for page objects. only contian `waitForVisibilityOf` method for now.
- `Utils`: contain methods mainly to get actual invoice value and expected invoice value.
- `InvoiceTest`: contains 3 automated test cases.
- `BaseTest`: for the pre-test (setting up the driver)

## Tips & How To Use:
- ### `invoiceNumber` input parameter
we will suppose the url is something like:

`hxxps://www .example.com/invoice/ 12345` where 12345 is the onvoice number

<img width="577" alt="2-invoice" src="https://github.com/Calisthrone/Invoicing-Automated-Test/assets/76989642/98ead565-6248-475d-b004-ede1f0a77d91">

this will help to navigate to the corresponding invoice.

<img width="583" alt="1-invoice" src="https://github.com/Calisthrone/Invoicing-Automated-Test/assets/76989642/23ac6967-ed2a-4a95-87b8-e0230c416beb">

## 

- ### `getAllStoredItems` method
this methods needs implementation according to the DB where all items data could be found.

<img width="487" alt="3-invoice" src="https://github.com/Calisthrone/Invoicing-Automated-Test/assets/76989642/dc6e0874-55a8-4c66-83b7-eafd0362fad8">

## 

- ### `getActualInvoiceValue` method
this method will takes in 4 input parameters:

`discount`: set to true if there is a discount to apply.

`discountPercentage`: the value of this parameter is irrelevant if discount boolean is set to false.

`vat`: set to rrue if there is a vat to apply.

`vatPercentage`: the value of this parameter is irrelevant if vat boolean is set to false.

<img width="739" alt="4-invoice" src="https://github.com/Calisthrone/Invoicing-Automated-Test/assets/76989642/38441a6c-591d-41b8-afbf-6694bb39e234">

By adding these 4 parameters, it is possible to test all scenarios (with or withouf discount / vat) using only one method, no need for overloading several methods.

<img width="619" alt="5-invoice" src="https://github.com/Calisthrone/Invoicing-Automated-Test/assets/76989642/1633e4b6-348f-426c-b788-6cd9cc6e4225">

## 
By implementing page object model, executing a test case is pretty much staight forward, readable and easy to maintain.

<img width="767" alt="6-invoice" src="https://github.com/Calisthrone/Invoicing-Automated-Test/assets/76989642/f582d6dc-dc86-4dcf-810c-ec7bccc9d918">

Note: this assert method is to be used for the all 3 test cases.

<img width="750" alt="8-invoice" src="https://github.com/Calisthrone/Invoicing-Automated-Test/assets/76989642/68d69f16-a69c-4017-983d-32b603ef3eff">


## Project Structure:

<img width="303" alt="7-invoice" src="https://github.com/Calisthrone/Invoicing-Automated-Test/assets/76989642/ea426549-c555-478c-855a-8789bd007537">
