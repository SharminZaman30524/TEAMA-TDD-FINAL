package progressive;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EmailProgressive extends CommonAPI {
    public EmailProgressive(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    /**WebElements**/
    @FindBy(xpath = "(//a[@class='link'][normalize-space()='Contact Us'])[1]")
    public WebElement contactUsButton;
    @FindBy(xpath = "(//button[normalize-space()='Send email'])[1]" )
    public WebElement sendEmailButton;
    @FindBy(css = "#topic")
    public WebElement emailTopicDropdown;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[4]/form[1]/div[1]/input[1]")
    public WebElement nameSection;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[4]/form[1]/div[2]/input[1]")
    public WebElement emailSection;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[4]/form[1]/div[5]/textarea[1]")
    public WebElement typeMessageSection;
    // @FindBy(xpath = "(//select[@id='jobsState'])[1]") public List<WebElement> stateDropdown;
    @FindBy(xpath = "(//select[@id='jobsState'])[1]")
    public WebElement stateDropdown;
    @FindBy(xpath = "(//label[normalize-space()='Working at Progressive'])[1]")
    public WebElement workingAtProgressiveSelected;
    //Webelement to assert Arizona has been selected
    @FindBy(xpath = "(//label[normalize-space()='Arizona'])[1]")
    public  WebElement arizonaSelected;
    @FindBy(xpath = "//label[@for='jobsTestimonial']//span[@class='check']")
    public WebElement checkbox;
    @FindBy(css = ".check.checked")
    public WebElement checkedCheckBox;
    @FindBy(css = "form[class='jobsContactForm invert grid'] input[value='Submit']")
    public WebElement submitEmail;
    @FindBy(xpath = "(//h2[contains(text(),'Got your message—thanks!')])[1]")
    public WebElement gotMessagePopUp;
    /**Steps associated with the test cases**/
    public void getToEmailProgressiveMethod(){
        click(contactUsButton);
        click(sendEmailButton);
    }
    public void clickNameInput(){
        click(nameSection);
    }
    public void nameInput(String name){
        type(nameSection,name);
    }
    public void clickEmailInput(){
        click(emailSection);
    }
    public void emailInput(String email){
        type(emailSection,email);
    }
    public void clickMassageInput(){
        click(typeMessageSection);
    }
    public void massageInput(String message){
        type(typeMessageSection,message);
    }
    public void submitEmailClick(){
        click(submitEmail);
    }
    //Test Cases
    /**
     *Test case to check the email topic dropdown is functional
     */
    public void selectEmailTopicDropdown(){
        selectDropDownByIndex(emailTopicDropdown,3);
        implicitWait(3);
    }
    /**
     * Test case to validate state dropdown
     * @param state
     */
    public void selectStateDropdown(String state){
        selectFromDropdown(stateDropdown,state);
    }
    /**
     * Test case to validate checkbox on email page
     */
    public void clickOnCheckBox(){
        click(checkbox);
        waitUntilVisible(checkedCheckBox);
    }
    /**
     * Test case to verify user is able to send an email through progressive
     */
    public void sendEmail() {
        getToEmailProgressiveMethod();
        selectEmailTopicDropdown();
        clickNameInput();
        nameInput("Lady Gaga");
        clickEmailInput();
        emailInput("celinepham125@gmail.com");
        clickMassageInput();
        massageInput("What positions are open?");
        selectStateDropdown("Arizona");
        clickOnCheckBox();
        submitEmailClick();
    }
}