package delta;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckInFeatures extends CommonAPI {


    @Test
    public void checkInBefore24Hours() throws InterruptedException {

        DeltaCheckInPage deltaCheckInPage = new DeltaCheckInPage(driver);
        deltaCheckInPage.clickCheckIn();
        deltaCheckInPage.clickConfirmationNumber();
        deltaCheckInPage.clickTicketNumber();
        deltaCheckInPage.clickTicketTab();
        deltaCheckInPage.typeInTicket("0067940120018");
        deltaCheckInPage.clickAirportField();
        deltaCheckInPage.enterAirport("MIAMI");
        deltaCheckInPage.clicknextButton();
        String errorMessage = deltaCheckInPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Whoops! We're sorry, but we are unable to find a check-in eligible reservation with the information provided.");

    }

}