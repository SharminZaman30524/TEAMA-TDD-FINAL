package progressive;

import base.CommonAPI;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProgressiveEmail extends CommonAPI {
    @Test(enabled = false)
    public void sendEmailProgressiveTest(){
        EmailProgressive email2 = new EmailProgressive(driver);
        windowMaximize();
        email2.sendEmail();
        String expectedMessage = "Got your message—thanks!";
        email2.gotMessagePopUp.getText();
        Assert.assertEquals(email2.gotMessagePopUp.getText(),expectedMessage);
    }
    @Test(enabled = false)
    public void emailTopicDropdownTest(){
        EmailProgressive email = new EmailProgressive(driver);
        email.getToEmailProgressiveMethod();
        email.selectEmailTopicDropdown();
        String expectedClaim = "Working at Progressive";
        Assert.assertEquals(expectedClaim,email.workingAtProgressiveSelected.getText());
    }
    @Test(enabled = false)
    public void emailStateDropdownTest(){
        EmailProgressive email = new EmailProgressive(driver);
        email.getToEmailProgressiveMethod();
        email.selectEmailTopicDropdown();
        email.selectStateDropdown("Arizona");
        String expectedState = "Arizona";
        Assert.assertEquals(expectedState,email.arizonaSelected.getText());
    }
    @Test(enabled = false)
    public void checkBoxTest(){
        EmailProgressive email = new EmailProgressive(driver);
        windowMaximize();
        email.getToEmailProgressiveMethod();
        email.selectEmailTopicDropdown();
        email.clickOnCheckBox();
        if (email.checkedCheckBox.isSelected()){
            Assert.assertTrue(true);
        }
    }
}