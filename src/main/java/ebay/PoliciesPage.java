package ebay;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static webelements.EbayWebElements.*;

public class PoliciesPage extends CommonAPI {
    @FindBy(xpath = thumbsDownButtonXpath) WebElement thumbsDownButton;
    @FindBy(xpath = dropdownOptionOneXpath) WebElement dropDownOptionOneRadioButton;
    @FindBy(xpath = postNegFeedbackMessageXpath) WebElement postNegFeedbackMessage;
    @FindBy(xpath = thumbsUpButtonXpath) WebElement thumbsUpButton;
    @FindBy(xpath = postPosFeedbackMessageXpath) WebElement postPosFeedbackMessage;
    @FindBy(xpath = prohibitedAndRestrictionsPoliciesXpath) WebElement prohibitedAndRestrictionsPoliciesButton;
    public PoliciesPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public void clickProhibitedAndRestrictionsPolicies(){
        click(prohibitedAndRestrictionsPoliciesButton);
    }
    public void clickThumbsDown(){
        click(thumbsDownButton);
    }
    public void dropDownOptionOne() {
        click(dropDownOptionOneRadioButton);
    }
    public String getPostNegFeedbackMessage() {
        return postNegFeedbackMessage.getText();
    }
    public void clickThumbsUp() {
        click(thumbsUpButton);
    }
    public String getPostPosFeedbackMessage() {
        return postPosFeedbackMessage.getText();
    }
}
