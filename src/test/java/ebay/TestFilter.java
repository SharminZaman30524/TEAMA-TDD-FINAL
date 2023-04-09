package ebay;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFilter extends CommonAPI {

    @Test(priority = 3, testName = "regression", enabled = false)
    public void testFilterDropdown(){
       InventoryPage1 inventoryPage = new InventoryPage1(driver);
       EbayHomepage1 searchBar = new EbayHomepage1(driver);
       searchBar.typeAndSearch("iphone");
        inventoryPage.clickOnFilterDropdown();
        inventoryPage.clickOnLowToHighFilter();
        List<Float> prices = inventoryPage.listOfPrices();
        //System.out.println(prices);
        List<Float> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        Assert.assertTrue(prices.equals(sortedPrices));
    }
    /**
     test case: Validate user is able to filter search results page by color
     1. Launch the app url with <chrome>
     2. Search for product
     3. Click on black color to filter the results
     4. Validate if results got filtered
     */
    @Test(priority = 2, testName = "regression")
    public void testFilterSunglassesSearchByColor() {
        EbayHomepage1 homepage = new EbayHomepage1(driver);
        InventoryPage1 inventoryPage = new InventoryPage1(driver);
        homepage.typeAndSearch("versace sunglasses");
        inventoryPage.clickBlackColorFrameCheckbox();
        String expectedResults = "Black\nRemove filter";
        String actualResults = inventoryPage.getVersaceResults();
        Assert.assertEquals(actualResults,expectedResults);
    }
    /**
     test case: Validate user is able to change Ebay’s category filter in the homepage
     1. Launch the app url with <chrome>
     2. Filter the category in the search bar of the homepage
     3. Validate if products on the homepage got filtered
     */
    @Test(priority = 1, testName = "regression", enabled = false)
    public void testChangeCategory() {
        EbayHomepage1 homepage = new EbayHomepage1(driver);
        InventoryPage1 inventoryPage = new InventoryPage1(driver);
        homepage.clickOnShopByCategoryButton();
        homepage.clickOnCameraAndPhotoButton();
        String expected = "Cameras & Photo";
        String actual = inventoryPage.getCamAndPhotoText();
        Assert.assertEquals(actual,expected);
    }

}
