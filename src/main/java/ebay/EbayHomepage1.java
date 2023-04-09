package ebay;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static webelements.EbayWebElements.*;

public class EbayHomepage1 extends CommonAPI {

    @FindBy(xpath = "//input[@id='gh-ac']") public WebElement searchBar;
    @FindBy(xpath = "//input[@id='gh-btn']") public WebElement searchBarButton;
    @FindBy(xpath = hoverOverCurrentCountryXpath) public WebElement hoverOverCurrentCountryDropdown;
    @FindBy(xpath = uruguaySiteChangeXpath) public WebElement uruguaySiteChangeButton;
    @FindBy(css = signInButtonCSS) public WebElement signInButton;
    @FindBy(xpath = shopByCategoryButtonXpath) public WebElement shopByCategoryButton;
    @FindBy(xpath = cameraAndPhotoCategoryButtonXpath) public WebElement cameraAndPhotoCategoryButton;
    @FindBy(xpath = signInSuccessHiMessageXpath) public WebElement signInSuccessHiMessage;
    @FindBy(xpath = jordanxXpath) public WebElement jordanText;
    @FindBy(xpath = sellButtonXpath) public WebElement sellButton;
    @FindBy(xpath = policiesButtonXpath) public WebElement policiesButton;
    @FindBy(xpath = careersButtonXpath) public WebElement careersButton;
    @FindBy(xpath = careersTextBoxXpath) WebElement careersTextBox;

    @FindBy(how = How.XPATH, using = Websearchcoloum) public WebElement Websearcher;
    @FindBy(how = How.XPATH, using = Editdiameter) public WebElement DiameterSetter;
    @FindBy(how = How.XPATH, using = checkingtherresult) public WebElement resultedcount;
    @FindBy(how = How.XPATH,using = selectingdesiredproduct)public WebElement SelectedAlloys12;
    @FindBy(how = How.XPATH,using = addtocart)public WebElement added;
    @FindBy(how = How.XPATH,using = AssertAlloyWheels)public WebElement verify;
    @FindBy(how = How.XPATH,using = VerifyAlloyWheels)public WebElement verify3;
    @FindBy(how = How.XPATH,using = VerifyAddedtoMyCart)public WebElement verify4;
    public EbayHomepage1(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /**Mehnaz's methods*/

    /**
     * Type any item in the ebay search bar and search
     * */
    public void typeItem(String item) {
        type(searchBar, item);
    }
    public void searchAnItem(){
        click(searchBarButton);
    }
    public void typeAndSearch(String item){
        type(searchBar, item);
        click(searchBarButton);
    }

    /**
     * Hover over any element
     */
    public void mouseHoverByXpath(String locator) {
    }
    public void clickOnUruguay(WebDriver driver) {

        click(uruguaySiteChangeButton);
    }
    public String getUrlLink(WebDriver driver) {

        return driver.getCurrentUrl();
    }
    public void clickOnSignInButton() {
        click(signInButton);
    }
    public void clickOnShopByCategoryButton() {
        click(shopByCategoryButton);
    }
    public void clickOnCameraAndPhotoButton() {
        click(cameraAndPhotoCategoryButton);
    }
    public String getHiMessage() {
        return signInSuccessHiMessage.getText();
    }
    public void clickOnJordan() {
        click(jordanText);
    }
    public void clickOnSellButton() {
        click(sellButton);
    }
    public void clickOnPoliciesButton() {
        click(policiesButton);
    }
    public void clickCareersButton(){
        click(careersButton);
    }
    public void typeAndEnter(WebElement element, String text) {
        super.typeAndEnter(element, text);
    }

/**Nicholas' methods*/
// All the steps to add Webelements
public void submitForSearchResult() {typeAndEnter(Websearcher,"Alloy Wheels");}
    public void maximunSize(){windowMaximize();}
    public void clickthediameter() {DiameterSetter.click();}
    public void Confirmation(){checkDisplayed(resultedcount);}
    public void clicktheOneIlike2 () {SelectedAlloys12.click();}
    public void scrooltoview () {scrollToView(SelectedAlloys12, driver);}
    public void CARTADDITION(){added.click();}
    public void waitDown_coolDown(){waitUntilClickAble(added);}
    public String VerifyAlooyewheelsDiameter(){return resultedcount.getText();}
    public String VerifyThatItISClickble(){return verify.getText();}
    public void NextTab(){handleNewTab(driver);}
    public String assertSelectingmyFavorate(){return added.getText();}
    public String assertaddedtoCart(){return verify4.getText();}


    // This is a test case for searching a product from the search bar of Ebay homepage and filtering it.


    public void checkOutMYResult() {
        submitForSearchResult();
        clickthediameter();
    }
    public void Actual_Result_Of_number(){
        submitForSearchResult();
        clickthediameter();
        Confirmation();
    }
    public void selecting_My_Favorate() throws InterruptedException {
        submitForSearchResult();
        clickthediameter();
        scrooltoview();
        clicktheOneIlike2();
        NextTab();
        Thread.sleep(300);
    }
    public void ADDING_TO_MY_EBAY_CART() throws InterruptedException {
        submitForSearchResult();
        clickthediameter();
        scrooltoview();
        clicktheOneIlike2();
        NextTab();
        Thread.sleep(3000);
        CARTADDITION();
    }
}


