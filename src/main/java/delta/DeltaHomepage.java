package delta;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeltaHomepage extends CommonAPI {


    Logger LOG = LoggerFactory.getLogger(CommonAPI.class);

    public DeltaHomepage(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//span[contains(text(),'From')]")
    WebElement fromSelection;

    @FindBy(xpath = "//input[@id='search_input']")
    WebElement originSearchBox;

    @FindBy(xpath = "//a[@class='airportLookup-list']//span//following-sibling::span")
    WebElement originSelection;

    @FindBy(xpath = "//div[@class='row']//a//span//following-sibling::span//following-sibling::span")
    WebElement fromLocation;

    //tempElement
    @FindBy(xpath = "//span[contains(text(),'Punta Cana, Dominican Republic')]")
    WebElement pujLocation;
    @FindBy(className= "_acsBadgeLabel") public WebElement feedBackButton;
    @FindBy(id = "acs_objPOP0248627") public WebElement inputFeedback;
    @FindBy(xpath = "//button[contains(text(),'Submit')]") public WebElement submitReviewButton;
    @FindBy(xpath = "//span[contains(text(),'Please fill in the required fields.')]") public WebElement displayedamessage;
    @FindBy(xpath = "//ngc-search[@class='d-none d-lg-block ng-tns-c0-0 ng-star-inserted']//a[@class='search icon-search-icon circle-outline']")public
    WebElement searchTopicsButton;
    @FindBy(xpath = "//input[@id='search_input']")public
    WebElement typeTopicsBar;
    @FindBy(xpath = "//h1[contains(text(),'Search Results')]") public WebElement resultDisplayed;
    /**Feedback Positive Message*/
    @FindBy(xpath = "//label[@aria-label='5 stars']") public WebElement star;
    @FindBy(xpath = "//label[@for='_POP0248607A010']//span[@class='verint-sdk-radio-svg-wrapper']") public WebElement reviewRadioButton;
    @FindBy(xpath = "//button[normalize-space()='OK']") public WebElement positiveFeedbackMessage;
    public void clickToSelection()
    {
        click(toSelection);
    }
    public void clickFromSelection(){click(fromSelection);
    }
    public void searchOrigin(String s){
        type(originSearchBox,s);
        click(originSelection);
    }

    public void searchDestination(String p){
        type(destinationSearchBox, p);
        click(destinationSelection);
    }

    public void selectTripTypeOneWay(){
        click(tripTypeRoundTrip);
        click(tripTypeOneWay);
    }

    public void clickPuj(){
        click(pujLocation);
    }

    public void clickLax(){
        click(laxLocation);
    }

    public String getFromLocation(){
        return getElementTextWithElement(pujLocation);

    }
    public String getToLocation(){
        return getElementTextWithElement(laxLocation);
    }

    public String hasReturnFlight(){
        return returnDate.getAttribute("style");
    }





    @FindBy(xpath = "//span[contains(text(),'To')]")
    WebElement toSelection;

    @FindBy(xpath = "//input[@id='search_input']")
    WebElement destinationSearchBox;

    @FindBy(xpath ="//span[@class='airport-city col-sm-10 col-md-11 col-lg-10 col-xl-10 col-xxl-10 pl-0']")
    WebElement destinationSelection;

    @FindBy(xpath ="//*[@id=\"airport-serach-panel\"]/div/div[2]/div/ul/li/a/span[2]")
    WebElement toLocation;

    @FindBy(xpath = "//span[contains(text(),'Los Angeles, CA')]")
    WebElement laxLocation;


    //TRIP TYPE ONE WAY
    @FindBy(xpath = "//li[@id='ui-list-selectTripType1']")
    WebElement tripTypeOneWay;

    //TRIP TYPE ROUND TRIP/default option
    @FindBy(xpath ="//span[@id='selectTripType-val']")
    WebElement tripTypeRoundTrip;

    //Depart and Return


    @FindBy(xpath = "//span[@class='calenderDepartSpan']")
    WebElement departDate;
    @FindBy(xpath = "//span[@class='calenderReturnSpan calendar-placeholder']")
    WebElement returnDate;

    @FindBy(xpath = "//div[@id='input_departureDate_1']")
    WebElement calendar;

    @FindBy(xpath = "//a[@aria-label='18 April 2023, Tuesday']")
    WebElement apr18;

    @FindBy(xpath = "//button[@value='done']")
    WebElement done;

    @FindBy(xpath = "//span[@id='passengers-val']")
    WebElement numberOfPassengers;

    @FindBy(xpath = "//li[@id='ui-list-passengers1']")
    WebElement twoPassenger;

    @FindBy (xpath = "//*[@id='passengers-val']")
    WebElement passengerCount;

    @FindBy(xpath = "//button[@id='btn-book-submit']")
    WebElement nextButton;



    public void clickNext(){
        click(nextButton);
    }
    public void clickDepart(){
        click(calendar);
    }

    public void clickApr18(){
        click(apr18);
    }
    public void clickPassengerQuantity(){
        click(numberOfPassengers);

    }
    public void clickTwoPassenger(){
        click(twoPassenger);
    }

    public void clickDone(){
        click(done);
    }

    public String getReturnDate(){
        return getTextFromWebElement(departDate);
    }







    public String getPassengerCount(){
        return getTextFromWebElement(passengerCount);
    }


    public void clickOnSearchTopicButton(){
        click(searchTopicsButton);
    }
    public void enterTopicstoSearch(){
        typeAndEnter(typeTopicsBar,"promotion");
    }
    public String textDisplayed(){
        return   resultDisplayed.getText();

    }
    public void clickOnFeedbackButton(){
        click(feedBackButton);
    }
    public void enterFeedback(String feedback){
        type(inputFeedback, feedback);
    }
    public void submitReview(){
        click(submitReviewButton);
    }
    public String displayedtext(){
        return displayedamessage.getText();
    }
    public void clickStar() {click(star);}
    public void clickReviewRadioButton() {click(reviewRadioButton);}
    public String getPositiveMessage() {return getText(positiveFeedbackMessage);}

}