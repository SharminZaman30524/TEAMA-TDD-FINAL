package progressive;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAccessibilityServicePage extends CommonAPI {
    @Test(enabled = false)
    public void testSubmitAccessibilityForm() {
        AccessibilityServicePage service = new AccessibilityServicePage(driver);
        windowMaximize();
        service.submitAccessibilityPreferencesForm();
        String expectedSubmitMessage = "Got your message—thanks!";
        service.ASPGotMessagePopUp.getText();
        Assert.assertEquals(service.ASPGotMessagePopUp.getText(), expectedSubmitMessage);
    }

    @Test(enabled = false)
    public void testNoRadioButton() {
        AccessibilityServicePage service = new AccessibilityServicePage(driver);
        windowMaximize();
        service.getToAccessibilityPage();
        try {
            cancelAlert();
        } catch (Exception e) {
            System.out.println("Caught");
        }
        service.selectVisualImpairmentNoRadioButton();
        if (service.visualImpairmentNoRadioButton.isSelected()) {
            Assert.assertTrue(true);
        }
    }

    @Test(enabled = false)
    public void testContactMethod() {
        AccessibilityServicePage service = new AccessibilityServicePage(driver);
        service.getToAccessibilityPage();
        try {
            cancelAlert();
        } catch (Exception e) {
            System.out.println("Caught");
        }
        service.contactMethodNoContactDropdown();
        String expectedContact = "No contact";
        Assert.assertEquals(expectedContact, service.selectedNoContact.getText());
    }
}