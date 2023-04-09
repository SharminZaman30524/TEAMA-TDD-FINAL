package delta;

import base.CommonAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomepage extends CommonAPI {
    @Test (priority = 1)
    public void searchOrigin() throws InterruptedException {

        DeltaHomepage deltaHomepage = new DeltaHomepage(driver);
        deltaHomepage.clickFromSelection();

        deltaHomepage.searchOrigin("PUJ");
        Thread.sleep(3000);
        String fromLocation = deltaHomepage.getFromLocation();
        Assert.assertEquals(fromLocation, "Punta Cana, Dominican Republic");
        System.out.println("Assertion Passed");

    }

    @Test (priority = 2)
    public void searchDestination() throws InterruptedException {
        DeltaHomepage deltaHomepage = new DeltaHomepage(driver);
        deltaHomepage.clickToSelection();
        deltaHomepage.searchDestination("LAX");
        Thread.sleep(3000);
        String toLocation = deltaHomepage.getToLocation();
        Assert.assertEquals(toLocation, "Los Angeles, CA");
        System.out.println("Assertion Passed");

    }

    @Test(priority =3)
    public void selectTripType(){
        DeltaHomepage deltaHomepage = new DeltaHomepage(driver);

        deltaHomepage.selectTripTypeOneWay();

        String returnFlight = deltaHomepage.hasReturnFlight();
        Assert.assertEquals(returnFlight,"display: none;");

    }

    @Test(priority =4)
    public void selectDate(){
        DeltaHomepage deltaHomepage = new DeltaHomepage(driver);

        deltaHomepage.selectTripTypeOneWay();

        deltaHomepage.clickDepart();
        deltaHomepage.clickApr18();
        deltaHomepage.clickDone();

        String departDate= deltaHomepage.getReturnDate();

        Assert.assertEquals(departDate,"Apr 18");


    }

    @Test (priority = 5)
    public void selectNumberOfPassenger(){
        DeltaHomepage deltaHomepage = new DeltaHomepage(driver);
        deltaHomepage.clickPassengerQuantity();
        deltaHomepage.clickTwoPassenger();

        String passCount = deltaHomepage.getPassengerCount();

        Assert.assertEquals(passCount, "2 Passengers");




    }

}