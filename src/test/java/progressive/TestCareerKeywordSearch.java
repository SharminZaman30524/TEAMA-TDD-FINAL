package progressive;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCareerKeywordSearch extends CommonAPI {
    static CareersPage careersPage;

    @Test
    public void testKEYWORDSearchBar() {

            careersPage = new CareersPage(driver);
            careersPage.searchUsingKEYWORD("engineer");

        List<String> engineerResults = careersPage.listOfPositionsUsingKeyword();
        for (String result : engineerResults) {
            if (engineerResults.contains("Engineer") || engineerResults.contains("Data Scientist")) {
                Assert.assertTrue(true);
            } else {
                Assert.assertFalse(true);
            }
        }
    }

}

