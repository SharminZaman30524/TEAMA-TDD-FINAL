package progressive;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCareerCategory extends CommonAPI {
    static CareersPage careersPage;

    @Test
    public void testJobCategoryFilter() {
        careersPage = new CareersPage(driver);
            careersPage.selectSalesJobCategoryFilter("Sales");
        List<String> salesResults = careersPage.listOfSalesPositions();
        for (String result : salesResults) {
            if (salesResults.contains("Territory Sales Representative")) {
                Assert.assertTrue(true);
            } else {
                Assert.assertFalse(true);
            }
        }

    }
}



