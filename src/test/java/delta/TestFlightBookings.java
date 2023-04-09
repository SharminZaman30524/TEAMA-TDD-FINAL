package delta;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFlightBookings extends CommonAPI {

    @Test
    public void testTripSummary() throws InterruptedException {
        DeltaHomepage deltaHomepage = new DeltaHomepage(driver);
        FlightResultsPage flightResultsPage = new FlightResultsPage(driver);
        deltaHomepage.clickFromSelection();

        deltaHomepage.searchOrigin("PUJ");
        String fromLocation = deltaHomepage.getFromLocation();
        Assert.assertEquals(fromLocation, "Punta Cana, Dominican Republic");
        System.out.println("Assertion Passed");

        deltaHomepage.clickToSelection();
        deltaHomepage.searchDestination("LAX");
        String toLocation = deltaHomepage.getToLocation();
        Assert.assertEquals(toLocation, "Los Angeles, CA");
        System.out.println("Assertion Passed");

        deltaHomepage.selectTripTypeOneWay();

        String returnFlight = deltaHomepage.hasReturnFlight();
        Assert.assertEquals(returnFlight,"display: none;");

        deltaHomepage.clickDepart();
        deltaHomepage.clickApr18();
        deltaHomepage.clickDone();

        String departDate= deltaHomepage.getReturnDate();

        Assert.assertEquals(departDate,"Apr 18");

        deltaHomepage.clickPassengerQuantity();
        deltaHomepage.clickTwoPassenger();

        String passCount = deltaHomepage.getPassengerCount();

        Assert.assertEquals(passCount, "2 Passengers");

        deltaHomepage.clickNext();


        String title= driver.getTitle();
        Assert.assertEquals(title,"Delta Air Lines | Flights & Plane Tickets + Hotels & Rental Cars");
//
    }
}