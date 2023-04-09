package delta;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeltaCheckInPage extends CommonAPI {

    Logger LOG = LoggerFactory.getLogger(CommonAPI.class);


    public DeltaCheckInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }




    @FindBy(xpath = "//a[@id='headPrimary2']")
    WebElement checkInTab;




    @FindBy(xpath ="//span[@id='searchType-val']")

    WebElement confirmationNumber;

    @FindBy(xpath = "//li[@id='ui-list-searchType2']")
    WebElement ticketNumber;




    @FindBy(xpath ="//input[@id='eticketNumber']")

    WebElement inputTicketNumber;

    @FindBy(xpath = "//a[@id='departureAirportLink']")
    WebElement airportField;

    @FindBy(xpath = "//input[@id='search_input']")
    WebElement originSearchBox;

    @FindBy(xpath = "//span[@class='airport-code col-sm-2 col-md-1 col-lg-2 col-xl-2 col-xxl-2 pl-0 pr-3']")
    WebElement originSelection;

    @FindBy(xpath = "//div[@id='findbyfailed']")
    WebElement failedCheckInMessage;

    @FindBy(xpath = "//button[@id='btn-checkin-submit']")
    WebElement hitNext;




    public void clicknextButton(){

        click(hitNext);
    }





    public void clickAirportField(){

        click(airportField);
    }

//    @FindBy(xpath = "")


    public void clickCheckIn() {
        click(checkInTab);
    }

    public void clickConfirmationNumber() {
        click(confirmationNumber);
    }

    public void clickTicketNumber() {
        click(ticketNumber);
    }

    public void clickTicketTab() {
        click(inputTicketNumber);
    }

    public void typeInTicket(String number) {
        type(inputTicketNumber, number);
    }

    public void enterAirport(String q) {
        type(originSearchBox, q);
        click(originSelection);
    }

    public String getErrorMessage() {
        return failedCheckInMessage.getText();
    }
}
