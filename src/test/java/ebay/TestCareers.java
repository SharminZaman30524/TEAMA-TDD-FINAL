package ebay;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCareers extends CommonAPI {
    /**
     test case: Validate if user’s starred positions in Careers page is selected
     1. Launch the app url with <chrome>
     2. Click on Careers button
     3. Search "engineers" in input box
     4. Select position one
     5. Select position two
     6. Validate if both positions got selected
     */
    @Test(enabled=false)
    public void testMultipleStarredPositions() throws InterruptedException {
        EbayHomepage1 ebayHomepage = new EbayHomepage1(driver);
        InventoryPage1 inventoryPage = new InventoryPage1(driver);
        ebayHomepage.clickCareersButton();
        ebayHomepage.typeAndEnter(ebayHomepage.careersTextBox, "engineer");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        inventoryPage.clickStar(inventoryPage.starPositionOneButton);
        inventoryPage.clickStar(inventoryPage.starPositionTwoButton);
        List<WebElement> multiplePositionsSelected = inventoryPage.starredPositions;
        for (WebElement stars : multiplePositionsSelected ) {
            if (stars.isSelected()) {
                Assert.assertTrue(true);
            }
            Assert.assertTrue(false);
        }
    }
    /**
     test case: Validate if user’s starred position in Careers page is selected
     1. Launch the app url with <chrome>
     2. Click on Careers button
     3. Search "engineers" in input box
     4. Select position one
     5. Validate if single position got selected
     */
    @Test(testName = "regression testing", priority = 1)
    public void testSingleStarredPositions() {
        EbayHomepage1 ebayHomepage = new EbayHomepage1(driver);
        InventoryPage1 inventoryPage = new InventoryPage1(driver);
        inventoryPage = new InventoryPage1(driver);
        ebayHomepage.clickCareersButton();
        ebayHomepage.typeAndEnter(ebayHomepage.careersTextBox, "engineer");
        inventoryPage.clickStarOne();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        boolean expected = true;
        boolean actual = inventoryPage.positionIsSelected(inventoryPage.starPositionOneButton);
        Assert.assertEquals(actual,expected);
    }
}
