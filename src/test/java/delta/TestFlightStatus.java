package delta;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFlightStatus extends CommonAPI {

    @Test
    public void TestFlightstatusFunction() throws InterruptedException {
        DeltaFlightStatus delta =new DeltaFlightStatus(driver);
        delta.clickOnFlightStatusLink();
        delta.enterCityDeparture("newark");
        delta.enterCityArrival("miami");
        delta.clickInFlightstatutsubmit();
        String expected="Flight Schedules";
        Thread.sleep(3000);

    }
}
