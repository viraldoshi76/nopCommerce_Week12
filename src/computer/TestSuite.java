package computer;

import browserTesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TestSuite extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    /**
     * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
     * 	1.1 Click on Computer Menu.
     * 	1.2 Click on Desktop
     * 	1.3 Select Sort By position "Name: Z to A"
     * 	1.4 Verify the Product will arrange in Descending order.
     */
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        //String actualMessage = selectByValueDropDown(By.id("products-orderby"),"6");
        //WebElement single = driver.findElement(By.xpath("//div[@class='item-grid']/descendant::a"));
        Select select =new Select(driver.findElement(By.id("products-orderby")));
        select.selectByVisibleText("Name: A to Z");

        List<WebElement> tool = (List<WebElement>) driver.findElement(By.xpath("//div[@class='products-container']"));
        String[] linktext = new String[tool.size()];
        int i=0;
        for (WebElement x:tool) {
            linktext[i]=x.getText();
            i++;
        }
        if (!checkDescendingOrder(linktext)){
            System.out.println("not sorted");
        }




        /*selectByValueDropDown(By.id("products-orderby"),"6");
        String expectedMessage = "6";*/
        /*Assert.assertEquals("not into the page",expectedMessage,actualMessage);*/
    }

    /**
     * Test name verifyProductAddedToShoppingCartSuccessFully()
     * 	2.1 Click on Computer Menu.
     * 	2.2 Click on Desktop
     * 	2.3 Select Sort By position "Name: A to Z"
     * 	2.4 Click on "Add To Cart"
     * 	2.5 Verify the Text "Build your own computer"
     * 	2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
     * 	2.7.Select "8GB [+$60.00]" using Select class.
     * 	2.8 Select HDD radio "400 GB [+$100.00]"
     * 	2.9 Select OS radio "Vista Premium [+$60.00]"
     *            	2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
     * 	2.11 Verify the price "$1,475.00"
     * 	2.12 Click on "ADD TO CARD" Button.
     * 	2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
     * After that close the bar clicking on the cross button.
     * 	2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
     * 	2.15 Verify the message "Shopping cart"
     * 	2.16 Change the Qty to "2" and Click on "Update shopping cart"
     * 	2.17 Verify the Total"$2,950.00"
     * 	2.18 click on checkbox “I agree with the terms of service”
     * 	2.19 Click on “CHECKOUT”
     * 	2.20 Verify the Text “Welcome, Please Sign In!”
     * 	2.21Click on “CHECKOUT AS GUEST” Tab
     * 	2.22 Fill the all mandatory field
     * 	2.23 Click on “CONTINUE”
     * 	2.24 Click on Radio Button “Next Day Air($0.00)”
     * 2.25 Click on “CONTINUE”
     * 2.26 Select Radio Button “Credit Card”
     * 2.27 Select “Master card” From Select credit card dropdown
     * 2.28 Fill all the details
     * 2.29 Click on “CONTINUE”
     * 2.30 Verify “Payment Method” is “Credit Card”
     * 2.32 Verify “Shipping Method” is “Next Day Air”
     * 	2.33 Verify Total is “$2,950.00”
     * 	2.34 Click on “CONFIRM”
     * 	2.35 Verify the Text “Thank You”
     * 	2.36 Verify the message “Your order has been successfully processed!”
     * 	2.37 Click on “CONTINUE”
     * 2.37 Verify the text “Welcome to our store”
     */
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//h2[@class='title']/a[@title='Show products in category Desktops']"));
        selectByValueDropDown(By.id("products-orderby"),"5");
        Thread.sleep(5000);
        clickOnElement(By.xpath("//div[@class='buttons']//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']"));
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        String expectedMessage = "Build your own computer";
        Assert.assertEquals("not found",expectedMessage,actualMessage);
        selectByValueDropDown(By.xpath("//select[@id='product_attribute_1']"),"1");
        selectByValueDropDown(By.xpath("//select[@id='product_attribute_2']"),"5");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(4000);
        verifyMessage("please select right spec","$1,475.00",By.xpath("//span[@id='price-value-1']"));
        /*String amt ="$1,475.00";
        String tamt = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Thread.sleep(2000);
        Assert.assertEquals("please select right spec",amt,tamt);*/

        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        String amessage=getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        String emessage = "The product has been added to your shopping cart";
        Assert.assertEquals("it is not added",emessage,amessage);
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        Actions actions = new Actions(driver);
        WebElement shoppingCart = driver.findElement(By.xpath("//li[@id='topcartlink']"));
        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        actions.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();

        verifyMessage("not found","Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));

        WebElement qty = driver.findElement(By.xpath("//input[@id='itemquantity11230']"));
        qty.clear();
        qty.sendKeys("2");
        clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));
        verifyMessage("its not update","$2,950.00",By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));
        verifyMessage("you not clicked","Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"prime");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"time");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"prime@gmail.com");
        selectByValueDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"233");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"london");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"123 bilmont road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"n23 bv3");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"02086597851");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        selectByValueDropDown(By.xpath("//select[@id='CreditCardType']"),"MasterCard");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"prime time");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5248298291722370");
        selectByValueDropDown(By.xpath("//select[@id='ExpireMonth']"),"3");
        selectByValueDropDown(By.xpath("//select[@id='ExpireYear']"),"2022");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"203");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        verifyMessage("its not credit card","Credit Card",By.xpath("//span[contains(text(),'Credit Card')]"));
        verifyMessage("its not air service","Next Day Air",By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        verifyMessage("amount is wrong", "$2,950.00",By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        verifyMessage("there in no message","Thank you",By.xpath("//h1[contains(text(),'Thank you')]"));
        verifyMessage("order has not been successfull","Your order has been successfully processed!",By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        verifyMessage("You have not registered yet","Welcome to our store",By.xpath("//h2[contains(text(),'Welcome to our store')]"));







    }
}