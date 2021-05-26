package homepage;

import browserTesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    /**
     * ●	Create the package homepage
     *
     * 1. create class "TopMenuTest"
     *  	1.1 create method with name "selectMenu" it has one parameter name "menu" of  type string
     * 	1.2 This method should click on the menu whatever name is passed as parameter.
     * 	1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
     */

    String baseUrl = "https://demo.nopcommerce.com/";
    String expectedMessage;

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }



    public void selectMenu(String menu){


        expectedMessage = menu;
    }

    @Test
    public void verifyPageNavigation(){


        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        selectMenu("Computers");
        Assert.assertEquals("user is not on page",expectedMessage,actualMessage);

    }

}
