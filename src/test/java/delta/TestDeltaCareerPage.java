package delta;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestDeltaCareerPage extends CommonAPI {

    @Test(enabled = true)
    public void testCareerLocation() throws InterruptedException {
        DeltaCareerPage location = new DeltaCareerPage(driver);
        location.clickLocationDropdown();
        location.enterStateInDropdownSearchBar("United States, New York, New York");
        Thread.sleep(3000);
        location.clickStateResultDropdown();
        location.clickSearchNow();
        String locationNewYork = "United States";
        List<String> getNewYorkResults = location.getNewYorkResults();
        for (String newYork : getNewYorkResults) {
            if (newYork.contains(locationNewYork)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertFalse(true);
            }
        }
    }

    @Test(enabled = true)
    public void testKeywordSearch() {
        DeltaCareerPage keyword = new DeltaCareerPage(driver);
        keyword.enterCareerKeyword("engineer");
        String career = "Engineer";
        List<String> getEngineerResults = keyword.getEngineerResults();
        for (String engineer: getEngineerResults) {
            if (engineer.contains(career)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertFalse(true);
            }
        }
    }
    @Test(enabled = true)
    public void testJobCategory() {
        DeltaCareerPage category = new DeltaCareerPage(driver);
        category.useJobCategory("Finance & Accounting");

        List<String> getCategoryResults = category.getJobCategoryResults();
        for (String finance : getCategoryResults) {
            if (finance.contains("Manager")||finance.contains("Finance")) {
                Assert.assertTrue(true);
            } else {
                Assert.assertFalse(true);
            }
        }
    }
}






