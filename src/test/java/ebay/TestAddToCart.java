package ebay;

import base.CommonAPI;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAddToCart extends CommonAPI {
    /**
     test case: Validate user is able to add valid item to cart
     1. Launch the app url with <chrome>
     2. Click on trending Jordan sneakers in the homepage
     3. Select jordan sneaker in the results page
     4. Click add to cart
     5. Validate item got added to cart by getting the confirmation text
     */
    @Test(testName = "functional testing", priority = 1, enabled = false)
    public void testAddToCart() {
        EbayHomepage1 homepage = new EbayHomepage1(driver);
        ProductPage productPage = new ProductPage(driver);
        homepage.clickOnJordan();
        productPage.clickOnJordanResult();
        productPage.enterQuantity("");
        productPage.addToCart();
        String expected = "Sign in to check out";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String actual = productPage.getAddedToCartMessage();
        Assert.assertEquals(actual,expected);
    }
    /**
     test case: Verify user is unable to add more than current inventory to cart
     1. Launch the app url with <chrome>
     2. Click on trending Jordan sneakers in the homepage
     3. Select jordan sneaker in the results page
     4. Set high input amount in quantity input box
     4. Click add to cart
     5. Validate items cannot be added to cart by getting the error message
     */
    @Test(testName = "negative testing")
    public void testAddInsufficientInventoryToCart() {
        EbayHomepage1 homepage = new EbayHomepage1(driver);
        ProductPage productPage = new ProductPage(driver);
        homepage.clickOnJordan();
        productPage.clickOnJordanResult();
        productPage.enterQuantity("4");
        String expectedMessage = "Please enter a lower number";
        String actualMessage = productPage.getInsufficientInventoryMessage();
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
