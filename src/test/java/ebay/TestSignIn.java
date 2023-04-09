package ebay;

import base.CommonAPI;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSignIn extends CommonAPI {
    /**
     test case: Verify user is able to sign in to existing Ebay account
     1. Launch the app url with<chrome>
     2. Click on Sign In button
     3. Enter email/username
     4. Click continue to sign in
     5. Enter password
     6. Click sign in
     7. Validate
     */
    @Test(testName = "regression testing")
    public void testSignIn() {
        EbayHomepage1 homepage = new EbayHomepage1(driver);
        UserAccountPage signInPage = new UserAccountPage(driver);
        homepage.clickOnSignInButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        signInPage.enterExistingEmailORUsername("mehnazhp1@gmail.com");
        signInPage.clickContinueToSignIn();
        signInPage.enterExistingPassword("Finalproject1!");
        signInPage.clickSignInExistingAcc();
        String expected = "Mehnaz";
        String actual = homepage.getHiMessage();
        Assert.assertEquals(actual,expected);
    }
}
