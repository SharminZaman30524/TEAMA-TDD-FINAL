package ebay;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWatchList extends CommonAPI {
    /**
     test case: Validate watchlist
     1. Launch the app url with <chrome>
     2. Search for product
     3. Filter results on results page
     4. Click on heart icon on the desired product
     5. Validate item got added to watchlist
     */
    @Test(enabled = false)
    public void testWatchList() throws InterruptedException {
        EbayHomepage1 ebayHomepage = new EbayHomepage1(driver);
        InventoryPage1 inventoryPage = new InventoryPage1(driver);
        ProductPage addToCartPage = new ProductPage(driver);
        ebayHomepage.typeAndEnter(ebayHomepage.searchBar, "controller xbox one");
        inventoryPage.clickOnWirelessFilterCheckBox();
        inventoryPage.clickOnController();
        //Thread.sleep(5000);
        addToCartPage.addToWatchList();
        //controllerResultsPage.clickOnHeart();
        inventoryPage.clickWatchListDropDown();
        String actual = inventoryPage.getWatchList();
        String expected = "Molten Metal Xbox Series X/S Wireless Controller For Microsoft Xbox One";
        Assert.assertEquals(actual,expected);
        //controllerItemPage.addToWatchList();
    }
}
