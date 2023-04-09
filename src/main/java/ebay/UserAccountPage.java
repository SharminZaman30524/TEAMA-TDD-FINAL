package ebay;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static webelements.EbayWebElements.*;

public class UserAccountPage extends CommonAPI {
    @FindBy(xpath = createAccButtonXpath) public WebElement createAccButton;
    @FindBy(css = emailAndUserNameSignInInputCSS) public WebElement emailAndUserNameSignInInput;
    @FindBy(xpath = continueButtonSignInXpath) public WebElement continueButtonSignIn;
    @FindBy(xpath = passwordSignInInputXpath) public WebElement passwordSignInInput;
    @FindBy(xpath = signInButtonExistingAccXpath) public WebElement signInButtonExistingAcc;
    @FindBy(xpath = personalAccountButtonXpath) public WebElement personalAccountRadioButton;
    @FindBy(xpath = firstNameInputXpath) public WebElement firstNameInputField;
    @FindBy(xpath = lastNameInputXpath) public WebElement lastNameInputField;
    @FindBy(css = emailInputCSS) public WebElement emailInputField;
    @FindBy(css = passwordInputCSS) public WebElement passwordInputField;
    @FindBy(css = finalStepCreateAccountButtonCSS) public WebElement finalStepCreateAccountButton;

    public UserAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnCreateAccButton() {
        click(createAccButton);
    }

    public void enterExistingEmailORUsername(String emailOrUsername) {
        type(emailAndUserNameSignInInput, emailOrUsername);
    }
    public void clickContinueToSignIn() {
        click(continueButtonSignIn);
    }
    public void enterExistingPassword(String password) {
        type(passwordSignInInput, password);
    }
    public void clickSignInExistingAcc() {
        click(signInButtonExistingAcc);
    }
    public void clickOnPersonalAcct() {
        click(personalAccountRadioButton);
    }
    public void enterFirstNameAndLastName(String firstName, String lastName) {
        type(firstNameInputField, firstName);
        type(lastNameInputField, lastName);
    }
    public void enterEmail(String email) {
        type(emailInputField, email);
    }
    public void enterPassword(String password) {
        type(passwordInputField, password);
    }
    public void clickOnCreateAcc() {
        click(finalStepCreateAccountButton);
    }




}
