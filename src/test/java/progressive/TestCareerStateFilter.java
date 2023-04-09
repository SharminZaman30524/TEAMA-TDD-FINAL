package progressive;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCareerStateFilter extends CommonAPI {
    static CareersPage careersPage;

    @Test
    public void testStateFilter() throws InterruptedException {
        careersPage = new CareersPage(driver);
        careersPage.selectCaliforniaStateFilter();
        Thread.sleep(5000);
        List<String> getCaliforniaLocations = careersPage.listOfCaliforniaLocations();
        String expectedState = "California";
        for (String California : getCaliforniaLocations) {
            if (California.contains(expectedState)||California.contains("Multiple Locations")) {
                Assert.assertTrue(true);
            } else {
                Assert.assertFalse(true);
            }
        }
    }

}



