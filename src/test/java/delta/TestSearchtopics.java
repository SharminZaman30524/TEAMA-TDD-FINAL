package delta;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchtopics extends CommonAPI {

    @Test
    public void TestSearchTopicsfunction() {
        DeltaHomepage delta=new DeltaHomepage(driver);
        delta.clickOnSearchTopicButton();
        delta.enterTopicstoSearch();
        String expected="Search Results";
        String actualResults=delta.textDisplayed();
        Assert.assertEquals(expected,actualResults);
    }
}