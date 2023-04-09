package progressive;
import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessibilityServicePage extends CommonAPI {
    public AccessibilityServicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    /**WebElements**/
    @FindBy(xpath = "//a[@href='https://www.progressive.com/web-site-accessibility/']")
    public WebElement accessibilityServicesButton;
    @FindBy(css = "label[for='visualNo'] span[class='circle']")
    public WebElement visualImpairmentNoRadioButton;
    @FindBy(xpath = "(//span[@class='circle'])[7]")
    public WebElement assistiveToolQuestionNoRadioButton;
    @FindBy(css = "#accessibilityName")
    public WebElement nameInput;
    @FindBy(xpath = "(//select[@id='PreferredContactMethod'])[1]")
    public WebElement contactMethodDropDown;
    @FindBy(xpath = "(//div[contains(text(),'No contact')])[1]")
    public WebElement selectedNoContact;
    @FindBy(css = "input[value='Submit']")
    public WebElement accessibilityPageSubmitButton;
    @FindBy(xpath = "(//h2[contains(text(),'Got your message—thanks!')])[1]")
    public WebElement ASPGotMessagePopUp;
    /**Steps associated with the test cases**/
    public void getToAccessibilityPage(){
        click(accessibilityServicesButton);
    }
    public void clickInsertName(){
        click(nameInput);
    }
    public void insertName(String name){
        type(nameInput,name);
    }
    public void selectAccessibiltyPageSubmit(){
        click(accessibilityPageSubmitButton);
    }
    //Test cases
    /**
     * Test case to select Visual Impairment "No" Radio Button
     */
    public void selectVisualImpairmentNoRadioButton(){
        click(visualImpairmentNoRadioButton);
        implicitWait(5);
    }
    /**
     * Test case to select Assistive Tool "No" Radio Button
     */
    public void selectAssistiveToolQuestionNoRadioButton(){
        click(assistiveToolQuestionNoRadioButton);
        implicitWait(5);
    }
    /**
     * Test case to select contact dropdown
     */
    public void contactMethodNoContactDropdown(){
        selectDropDownByIndex(contactMethodDropDown,4);
    }
    /**
     * Test case to submit an Accessibility Preference Form
     */
    public void submitAccessibilityPreferencesForm(){
        getToAccessibilityPage();
        try{cancelAlert();}
        catch (Exception e){
            System.out.println("Caught");
        }
        selectVisualImpairmentNoRadioButton();
        selectAssistiveToolQuestionNoRadioButton();
        implicitWait(4);
        clickInsertName();
        insertName("Hannah Montana");
        contactMethodNoContactDropdown();
        selectAccessibiltyPageSubmit();
        waitUntilVisible(ASPGotMessagePopUp);
    }
}