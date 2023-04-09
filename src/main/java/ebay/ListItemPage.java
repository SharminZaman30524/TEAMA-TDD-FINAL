package ebay;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static webelements.EbayWebElements.*;

public class ListItemPage extends CommonAPI {
    @FindBy(xpath = macbookProductMatchXpath)
    WebElement macbookProductMatchButton;
    @FindBy(xpath = newConditionRadioButtonXpath) WebElement newConditionRadioButton;
    @FindBy(xpath = continueToListingXpath) WebElement continueToListingButton;
    @FindBy(xpath = listAnItemButtonXpath) WebElement listAnItemButton;
    @FindBy(xpath = listItemTextBoxXpath) WebElement listItemTextBox;
    @FindBy(xpath = verifyToContinueTextXpath) WebElement verifyToContinueText;



    public ListItemPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public void clickOnMatch() {
        click(macbookProductMatchButton);
    }
    public void clickOnCondition(){
        click(newConditionRadioButton);
    }
    public void clickOnContinue() {
        click(continueToListingButton);
    }
    public void clickListAnItem() {
        click(listAnItemButton);
    }
    public void typeAndEnter(WebElement element, String text) {
        super.typeAndEnter(element, text );
    }
    public String getVerifyToContText() {
        return verifyToContinueText.getText();
    }



}
