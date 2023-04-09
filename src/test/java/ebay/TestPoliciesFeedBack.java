package ebay;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPoliciesFeedBack extends CommonAPI {
    /**
     test case: Validate thumbs down feedback
     1. Launch the app url with<chrome>
     2. Click on the Policies link
     3. Click on Prohibited and Restrictions Poolicies link
     4. Click on thumbs down
     5. Click on drop down option one
     6. Validate
     */
    @Test()
    public void testThumbsDownFeedback() {
        EbayHomepage1 ebayHomepage = new EbayHomepage1(driver);
        PoliciesPage policiesPage = new PoliciesPage(driver);
        ebayHomepage.clickOnPoliciesButton();
        policiesPage.clickProhibitedAndRestrictionsPolicies();
        policiesPage.clickThumbsDown();
        policiesPage.dropDownOptionOne();
        String actual = policiesPage.getPostNegFeedbackMessage();
        String expected = "Thanks for the feedback!";
        Assert.assertEquals(actual,expected);
    }
    /**
     test case: Validate thumbs up feedback
     1. Launch the app url with<chrome>
     2. Click on the Policies link
     3. Click on Prohibited and Restrictions Poolicies link
     4. Click on thumbs up
     5. Validate
     */
    @Test(priority = 1, testName = "regression testing", enabled = false)
    public void testThumbsUpFeedback() {
        EbayHomepage1 ebayHomepage = new EbayHomepage1(driver);
        PoliciesPage policiesPage = new PoliciesPage(driver);
        ebayHomepage.clickOnPoliciesButton();
        policiesPage.clickProhibitedAndRestrictionsPolicies();
        policiesPage.clickThumbsUp();
        String expected = "Thank you for your feedback. If you have additional questions we would be happy to help you.";
        String actual = policiesPage.getPostPosFeedbackMessage();
        Assert.assertEquals(actual, expected);
    }

}
