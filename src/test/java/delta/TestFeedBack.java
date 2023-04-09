package delta;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFeedBack extends CommonAPI {

    @Test
    public void testFeedBackbuttonNegativeTest() throws InterruptedException {
        DeltaHomepage delta=new DeltaHomepage(driver);
        delta.clickOnFeedbackButton();
        delta.enterFeedback("bad experiance");
        delta.submitReview();

        String actual=delta.displayedtext();
        String expected="Please fill in the required fields.";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testFeedBackbuttonPositiveTest() {
        DeltaHomepage delta=new DeltaHomepage(driver);
        delta.clickOnFeedbackButton();
        delta.enterFeedback("great experience");
        delta.clickStar();
        delta.clickReviewRadioButton();
        delta.submitReview();
        String actualPositiveMessage=delta.getPositiveMessage();
        String expectedPositiveMessage="OK";
        Assert.assertEquals(actualPositiveMessage,expectedPositiveMessage);
    }
}