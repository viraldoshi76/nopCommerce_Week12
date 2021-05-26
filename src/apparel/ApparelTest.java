package apparel;

import browserTesting.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ApparelTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    @Test
    public void verifyUserShouldNavigateToAccessoriesPageSuccessfully(){
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[3]/a[1]"));
        verifyMessage("page is not navigated","Accessories",By.xpath("//h1[contains(text(),'Accessories')]"));

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[3]/a[1]"));
        Thread.sleep(2000);
        verifyMessage("page is not navigated","Accessories",By.xpath("//h1[contains(text(),'Accessories')]"));
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Ray Ban Aviator Sunglasses')]"));
        Thread.sleep(2000);
        verifyMessage("the link is not navigated","Ray Ban Aviator Sunglasses",By.xpath("//h1[contains(text(),'Ray Ban Aviator Sunglasses')]"));
        Thread.sleep(2000);
        verifyMessage("the price is not correct","$25.00",By.xpath("//span[@id='price-value-33']"));
        Thread.sleep(2000);
        WebElement qty = driver.findElement(By.xpath("//input[@id='product_enteredQuantity_33']"));
        qty.clear();
        qty.sendKeys("2");
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-33']"));
        Thread.sleep(2000);
        verifyMessage("product is not added","The product has been added to your shopping cart",By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        verifyMessage("not in shopping cart","Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        verifyMessage("qty is not correct","2",By.xpath("//input[@value='2']/parent::td"));
        Thread.sleep(2000);
        verifyMessage("its not correct amt","$50.00",By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        sendTextToElement(By.xpath("//input[@id='Email']"),"ruteshbhatt@gmail.com");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='Password']"),"rutesh1234");
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"rutesh");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"bhatt");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"ruteshbhatt@gmail.com");
        selectByValueDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"233");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"manchester");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"154 chester road");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"w24 2kl");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"02085697456");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='payment-details']/input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        Thread.sleep(2000);
        selectByValueDropDown(By.xpath("//select[@id='CreditCardType']"),"Amex");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Etha Robinson");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"3498 2848 3082 925");
        selectByValueDropDown(By.xpath("//select[@id='ExpireMonth']"),"2");
        Thread.sleep(2000);
        selectByValueDropDown(By.xpath("//select[@id='ExpireYear']"),"2028");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"241");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        verifyMessage("its not correct credit card","Credit Card",By.xpath("//span[contains(text(),'Credit Card')]"));
        Thread.sleep(2000);
        verifyMessage("there is no shipping method","Ground",By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Thread.sleep(2000);
        verifyMessage("incorrect amount","$50.00",By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        verifyMessage("there is no message","Thank you",By.xpath("//h1[contains(text(),'Thank you')]"));
        Thread.sleep(2000);
        verifyMessage("order has not been placed","Your order has been successfully processed!",By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        Thread.sleep(2000);
        verifyMessage("welcome message is not displayed","Welcome to our store",By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));







    }
}
