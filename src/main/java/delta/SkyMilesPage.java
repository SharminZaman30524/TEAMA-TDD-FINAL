package delta;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkyMilesPage extends CommonAPI {
    public SkyMilesPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    @FindBy(css = "label[for='first_name']") public WebElement Firstname;
    @FindBy(xpath = "//input[@id='last_name']")public WebElement Lastname;
    @FindBy(xpath = "//div[@id='idp-month__selected']")public  WebElement birthMonth;
    @FindBy(css = "#idp-date__selected")public WebElement birhtday;
    @FindBy(css = "#idp-year__selected") public WebElement birthYear;
    @FindBy(xpath = "//div[@id='idp-gender__selected']") public WebElement gender;
    @FindBy(id = "basic-info-next") public WebElement submitbasicsinfo;
    public void clickfirstname(){
        click(Firstname);
    }
/*public void inputFirstName(String firstname){
    type(Firstname,"malek");*/

/*public void clickonLastName(WebElement lastname){
    click(Lastname);
}*/

}
