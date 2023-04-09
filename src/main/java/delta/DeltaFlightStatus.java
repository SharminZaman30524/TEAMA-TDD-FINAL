package delta;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeltaFlightStatus extends CommonAPI {
    public DeltaFlightStatus(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id= "headPrimary4") public WebElement FlightStatuslink;
    @FindBy(xpath = "//a[@id='departcitylink']") public WebElement departureCity;
    @FindBy(xpath= "//a[@id='arrivalcitylink']")public WebElement arrivalCity;
    @FindBy(id="btn-flight-sts-submit") public WebElement FlightstatussubmitButton;
    @FindBy(xpath = "//ul//li[@class='airport-list ng-star-inserted']") public List<WebElement> cityDepartue;
    public void clickOnFlightStatusLink() {
        click(FlightStatuslink);

    }
    public void enterCityDeparture(String cityD){
        type(departureCity ,cityD);
        click(cityDepartue.get(0));
    }

    public void enterCityArrival(String cityA){
        typeAndEnter(arrivalCity ,cityA);
        click(cityDepartue.get(0));
    }
    public void clickInFlightstatutsubmit(){
        click(FlightstatussubmitButton);
    }
}