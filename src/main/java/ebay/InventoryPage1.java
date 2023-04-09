package ebay;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static webelements.EbayWebElements.*;

public class InventoryPage1 extends CommonAPI {

    @FindBy(xpath = "//span[@class='ebayui-ellipsis-2']") public List<WebElement> mugSearchResults;
    @FindBy(xpath = "//button[@aria-label='Sort selector. Best Match selected.']") public WebElement filterDropdown;
    @FindBy(xpath = "//span[text()='Price + Shipping: lowest first']") public WebElement priceLowToHigh;
    @FindBy(xpath = "//span[@class='s-item__price']") public List <WebElement> prices;
    @FindBy(xpath = camAndPhotoCategoryCheckXpath) public WebElement camAndPhotoButtonCheck;
    @FindBy(xpath = controllerProductSelectedXpath) WebElement controllerProductSelected;
    @FindBy(xpath = wirelessFilterCheckboxXpath) WebElement wirelessFilterCheckbox;
    @FindBy(xpath = watchControllerXpath) WebElement watchController;
    @FindBy(xpath = watchListDropDownXpath) WebElement watchListDropDown;
    @FindBy(xpath = productInWatchListXpath) WebElement productInWatchList;
    @FindBy(xpath = "//input[@aria-checked=\"true\"]") public List<WebElement> starredPositions;
    @FindBy(xpath = starPositionOneXpath) WebElement starPositionOneButton;
    @FindBy(xpath = starPositionTwoXpath) WebElement starPositionTwoButton;
    @FindBy(xpath = sunglassesResultsTextXpath) public WebElement sunglassesResultsText;
    @FindBy(xpath = blackColorFrameCheckBoxXpath) public WebElement blackColorFrameCheckbox;
    @FindBy(xpath = versaceBlackGlassesResultsTextXpath) public WebElement versaceBlackGlassesResultsText;


    public InventoryPage1(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /**
     * Search results and filter price low to high
     * */
    public List <String> getMugSearchResultText (){
        List <String> getMugSearchResultText= new ArrayList<>();
        for (WebElement element: mugSearchResults){
            getMugSearchResultText.add(getTextFromWebElement(element));
        }return getMugSearchResultText;
    }
    public void clickOnFilterDropdown(){
        click(filterDropdown);
    }
    public void clickOnLowToHighFilter(){
        click(priceLowToHigh);
    }
    public List <Float> listOfPrices(){
        List <Float> listPrices = new ArrayList();
        for(int i = 1;i < 70; i++){
           listPrices.add(Float.parseFloat(prices.get(i).getText().substring(1))) ;
        }
//        for(WebElement priceElements: prices){
//            if(!priceElements.getText().equals(" ")){
//                listPrices.add(getTextFromWebElement(priceElements));
//            }
         return listPrices;
    }
    public String getCamAndPhotoText() {
        return camAndPhotoButtonCheck.getText();
    }
    public void clickOnWirelessFilterCheckBox() {
        click(wirelessFilterCheckbox);
    }
    public void clickOnController() {
        click(controllerProductSelected);
    }
    public void clickOnHeart() {
        click(watchController);
    }
    public void clickWatchListDropDown() {
        click(watchListDropDown);
    }
    public String getWatchList() {
        return productInWatchList.getText();
    }
    public void clickStar(WebElement element) {
        click(element);
    }
    public void clickStarOne() {
        click(starPositionOneButton);
    }
    public boolean positionIsSelected(WebElement element) {
        if (element.isSelected()) {
            return true;
        }
        return false;
    }
    public List<WebElement> multiplePositionsSelected() {
        List<WebElement> multiplePositionsSelected = new ArrayList<>();
        for (WebElement element : starredPositions) {
            multiplePositionsSelected.add(element);
        }
        return multiplePositionsSelected;
    }
    public String getSunglassesResultsText() {
        return sunglassesResultsText.getText();
    }
    public void clickBlackColorFrameCheckbox() {
        click(blackColorFrameCheckbox);
    }
 /*  public List<String> getVersaceSunglassesSearchResultsText(){
        List<String> getVersaceSunglassesSearchResultsText = new ArrayList<>();
        for (WebElement v : versaceSunglassesSearchResults) {
            getVersaceSunglassesSearchResultsText.add(getTextFromWebElement(v));
        } return getVersaceSunglassesSearchResultsText;
    }*/
    public String getVersaceResults() {
        return versaceBlackGlassesResultsText.getText();
    }


}
