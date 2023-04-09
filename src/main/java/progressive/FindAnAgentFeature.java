package progressive;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindAnAgentFeature extends CommonAPI {
    public FindAnAgentFeature(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    /**WebElements**/
    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[2]/ul/li[2]/a") public WebElement findAnAgentButton;
    @FindBy(css = "#zipCode") public  WebElement zipCodeSelection;
    @FindBy(xpath = "(//button[@id='findAgentButton'])[1]")public WebElement agentPageFindAnAgentButton;

    /**Steps associated with the test case**/
    public void clickFindAnAgentButton(){click(findAnAgentButton);}
    public void clickZipCodeSelection(){click(zipCodeSelection);}
    public void clickAgentPageFindAnAgentButton(){click(agentPageFindAnAgentButton);}

    /**
     * This is a test case to validate the Find an agent feature
     * @param zipCode
     */
    public void FindAnAgentFeatureMethod(String zipCode) {
        //Select the "Find an agent" button on the page
        clickFindAnAgentButton();
        //Select the area for "Location" to enter zipcode
        clickZipCodeSelection();
        //After clicking the area, type in the zip code
        type(zipCodeSelection,zipCode);
        //After typing the zipcode in, click "Find an Agent" button
        clickAgentPageFindAnAgentButton();
        implicitWait(3);
    }
}