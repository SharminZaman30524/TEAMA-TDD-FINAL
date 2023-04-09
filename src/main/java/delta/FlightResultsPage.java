package delta;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightResultsPage extends CommonAPI {

    Logger LOG = LoggerFactory.getLogger(CommonAPI.class);

    public FlightResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='farecellgridview row m-0 childRowFlight1 gridfirstrow']//div[@class='col-sm-12 col-md-12 col-4 px-sm-0 col-lg farecellitem brandWrapperBE farecell1 ng-star-inserted']")
    WebElement basicFlight;

    public void clickBasicFlight() {
        click((basicFlight));
    }
}