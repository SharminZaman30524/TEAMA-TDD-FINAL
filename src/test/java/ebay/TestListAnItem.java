package ebay;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestListAnItem extends CommonAPI {
    /**
        test case: Validate list item to sell without login
        1. Launch the app url with<chrome>
        2. Click on the List An Item link
        3. Search for product you are selling
        4. Click on match
        5. Click on condition radio button
        6. Click on continue
        7. Validate
        */
    @Test(testName = "functional testing")
    public void TestListAnItem() {
        EbayHomepage1 homepage = new EbayHomepage1(driver);
        ListItemPage listItemPage = new ListItemPage(driver);
        homepage.clickOnSellButton();
        listItemPage.clickListAnItem();
        listItemPage.typeAndEnter(listItemPage.listItemTextBox, "Apple Macbook Pro intel Core i5 With 256 SSD 8GB RAM ");
        listItemPage.clickOnMatch();
        listItemPage.clickOnCondition();
        listItemPage.clickOnContinue();
        String actual = "Please verify yourself to continue";
        String expected = listItemPage.getVerifyToContText();
        Assert.assertEquals(actual,expected);


    }
}
