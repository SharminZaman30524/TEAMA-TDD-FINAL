package ebay;

import base.CommonAPI;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static webelements.EbayWebElements.hoverOverCurrentCountryXpath;

public class TestChangeCountrySite extends CommonAPI {
    /**
    test case: Validate user is able to change Ebay’s site to another country
    1. Launch the app url with <chrome>
    2. Hover over the current country menu to see all country website options
    3. Click on Uruguay
    4. Validate that the website's country changed by checking the url
    */
    @Test(testName = "regression testing")
    public void testChangeCountrySite() {
        EbayHomepage1 homepage = new EbayHomepage1(driver);
        homepage.mouseHoverByXpath(hoverOverCurrentCountryXpath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homepage.clickOnUruguay(driver);
        String expectedUrl = "https://uy.ebay.com/";
        String actual = homepage.getUrlLink(driver);
        Assert.assertEquals(actual,expectedUrl);
    }

}
