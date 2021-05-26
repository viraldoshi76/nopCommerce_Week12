package electronics;

import browserTesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElectronicsTest extends BaseTest {

        String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    /**
     * 1.	Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
     * 1.1 Mouse Hover on “Electronics” Tab
     * 1.2 Mouse Hover on “Cell phones” and click
     * 1.3 Verify the text “Cell phones”
     */
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
       clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
       verifyMessage("you are not cellphone page","Cell phones",By.xpath("//h1[contains(text(),'Cell phones')]"));

    }


    /**
     * 2.	Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
     * 	2.1 Mouse Hover on “Electronics” Tab
     * 2.2 Mouse Hover on “Cell phones” and click
     * 2.3 Verify the text “Cell phones”
     *  	2.4 Click on List View Tab
     * 	2.5 Click on product name “Nokia Lumia 1020” link
     * 	2.6 Verify the text “Nokia Lumia 1020”
     * 	2.7 Verify the price “$349.00”
     * 	2.8 Change quantity to 2
     * 	2.9 Click on “ADD TO CART” tab
     * 	2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
     * After that close the bar clicking on the cross button.
     * 	2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
     * 	2.12 Verify the message "Shopping cart"
     * 	2.13 Verify the quantity is 2
     * 2.14 Verify the Total $698.00
     * 2.15 click on checkbox “I agree with the terms of service”
     * 2.16 Click on “CHECKOUT”
     * 	2.17 Verify the Text “Welcome, Please Sign In!”
     *  	2.18 Click on “REGISTER” tab
     * 	2.19 Verify the text “Register”
     * 	2.20 Fill the mandatory fields
     * 	2.21 Click on “REGISTER” Button
     * 	2.22 Verify the message “Your registration completed”
     * 	2.23 Click on “CONTINUE” tab
     * 	2.24 Verify the text “Shopping card”
     * 	2.25 click on checkbox “I agree with the terms of service”
     * 	2.26 Click on “CHECKOUT”
     * 	2.27 Fill the Mandatory fields
     * 	2.28 Click on “CONTINUE”
     * 	2.29 Click on Radio Button “2nd Day Air ($0.00)”
     * 2.30 Click on “CONTINUE”
     * 2.31 Select Radio Button “Credit Card”
     * 2.32 Select “Visa” From Select credit card dropdown
     * 2.33 Fill all the details
     * 2.34 Click on “CONTINUE”
     * 2.35 Verify “Payment Method” is “Credit Card”
     * 2.36 Verify “Shipping Method” is “2nd Day Air”
     * 	2.37 Verify Total is “$698.00”
     * 	2.38 Click on “CONFIRM”
     * 	2.39 Verify the Text “Thank You”
     * 	2.40 Verify the message “Your order has been successfully processed!”
     * 	2.41 Click on “CONTINUE”
     * 2.42 Verify the text “Welcome to our store”
     * 2.43 Click on “Logout” link
     * 2.44 Verify the URL is “https://demo.nopcommerce.com/”
     * @throws InterruptedException
     */
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        verifyMessage("you are not cellphone page","Cell phones",By.xpath("//h1[contains(text(),'Cell phones')]"));
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));
        Thread.sleep(3000);
        verifyMessage("not navigated","Nokia Lumia 1020",By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Thread.sleep(4000);
        verifyMessage("price is not correct","$349.00",By.xpath("//span[@id='price-value-20']"));
        Thread.sleep(2000);
        WebElement qty =driver.findElement(By.name("addtocart_20.EnteredQuantity"));
        Thread.sleep(2000);
        qty.clear();
        qty.sendKeys("2");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        Thread.sleep(2000);
        verifyMessage("product is not added","The product has been added to your shopping cart",By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        verifyMessage("not in shopping cart","Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        verifyMessage("the qty is not correct","2",By.xpath("//input[@id='itemquantity11253']"));
        Thread.sleep(2000);
        verifyMessage("the total is incorrect", "$698.00",By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));
        verifyMessage("its not updated","Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        verifyMessage("you are not register page","Register",By.xpath("//h1[contains(text(),'Register')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"vikas");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='LastName']"),"patel");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='Email']"),"vikas@yahoo.com");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='Password']"),"vikas5236");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"vikas5236");
        clickOnElement(By.xpath("//button[@id='register-button']"));
        Thread.sleep(2000);
        verifyMessage("you not have regeistered yet","Your registration completed",By.xpath("//div[contains(text(),'Your registration completed')]"));
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(2000);
        verifyMessage("you are not in shopping cart","Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"233");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"london");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"123 marble road");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"w12 3ju");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"02082546957");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        Thread.sleep(2000);
        selectByValueDropDown(By.xpath("//select[@id='CreditCardType']"),"visa");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Jes Scott");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"4444 0242 4466 5325");
        Thread.sleep(2000);
        selectByValueDropDown(By.xpath("//select[@id='ExpireMonth']"),"4");
        Thread.sleep(2000);
        selectByValueDropDown(By.xpath("//select[@id='ExpireYear']"),"2029");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"557");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        Thread.sleep(2000);
        verifyMessage("its not right credit card","Credit Card",By.xpath("//span[contains(text(),'Credit Card')]"));
        Thread.sleep(2000);
        verifyMessage("not correct shipping method","2nd Day Air",By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Thread.sleep(2000);
        verifyMessage("its not correct amt","$698.00",By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        Thread.sleep(2000);
        verifyMessage("its not confirm","Thank you",By.xpath("//h1[contains(text(),'Thank you')]"));
        Thread.sleep(2000);
        verifyMessage("there is no message displayed","Your order has been successfully processed!",By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        Thread.sleep(2000);
        verifyMessage("there is no welcome message","Welcome to our store",By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals("its not correct url",url,"https://demo.nopcommerce.com/");












    }



}
