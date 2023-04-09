package progressive;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFindAnAgent extends CommonAPI {
    @Test(enabled = true)
    public void testFindAnAgent(){
        windowMaximize();
        FindAnAgentFeature agent = new FindAnAgentFeature(driver);
        agent.FindAnAgentFeatureMethod("08244");
        String actualTitle = driver.getTitle();
        String expectedTile = "Find An Insurance Agent Near You | Progressive Agent";
        Assert.assertEquals(actualTitle,expectedTile);
    }
}