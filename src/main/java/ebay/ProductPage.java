package ebay;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static webelements.EbayWebElements.*;

public class ProductPage extends CommonAPI {
    @FindBy(xpath = jordanResultXpath) public WebElement jordanResult;
    @FindBy(xpath = jordanQuantityInputXpath) public WebElement jordanQuantityInputBox;
    @FindBy(xpath = insufficientInventoryMessageXpath) public WebElement insufficientInventoryMessage;
    @FindBy(xpath = jordanAddToCartXpath) public WebElement jordanAddToCartButton;
    @FindBy(xpath = jordanAddedToCartSuccessfullyXpath) public WebElement addedToCartSuccessfully;
    @FindBy(xpath = addControllerToWatchListXpath) WebElement addControllerToWatchList;

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void clickOnJordanResult() {
        click(jordanResult);
    }

    public void enterQuantity(String quantity) {

        type(jordanQuantityInputBox, quantity);
    }
    public String getInsufficientInventoryMessage() {
        return insufficientInventoryMessage.getText();
    }
    public void addToCart() {
        click(jordanAddToCartButton);
    }
    public String getAddedToCartMessage() {
        return addedToCartSuccessfully.getText();
    }
    public void addToWatchList() {
        click(addControllerToWatchList);
        handleNewTab(driver);
    }

}
