package progressive;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClaimsPage extends CommonAPI {

    /** Negative test - login with invalid credentials*/
    @FindBy(css = "#login_link") public WebElement loginLink;
    @FindBy(xpath = "//input[contains(@analytics-id,'718281DA')]") public WebElement loginUserName;
    @FindBy(xpath = "//input[contains(@analytics-id,'12C384FE')]") public WebElement loginPassword;
    @FindBy(xpath = "//span[contains(text(),'Log In')]") public WebElement loginButton;

    /** Auto quote page*/

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/ul/li[3]/a/p[1]") public WebElement autoBar;
    @FindBy(xpath = "//*[@id=\"zipCode_overlay\"]") public WebElement autoQuote;
    //@FindBy(xpath = "//*[@id=\"qsButton_overlay\"]") public WebElement getQuote;

    /**Searching items using searchbar used for list-down search and blank search*/
    @FindBy(id = "searchTerm") public WebElement searchBar;
    @FindBy(xpath = "//input[@id='search-input']") public WebElement searchBar2;
    //@FindBy(id = "autocomplete-result-1") public WebElement dropDownAuto;


    /**Auto Insurance claims button produces the claim instruction page*/
    @FindBy(css = "#claims") public WebElement claimsLink;
    @FindBy(xpath = "//a[contains(text(),'Auto Process')]") public WebElement autoInsurance;

    /***claims login button is access*/
    //use claimsLink WebElement
    @FindBy(xpath = "//a[contains(text(),'Claims Overview')]") public WebElement claimsView;
    @FindBy(xpath = "//a[contains(text(),'Report or view a claim')]") public WebElement reportClaim;
    @FindBy(css = "#claims_login_link_nonpni") public WebElement claimsLogin;

    /**verify if claims report login with invalid policy number**/
    //use Claims report method
    @FindBy(xpath = "//input[contains(@analytics-id,'137BBD4C')]") public WebElement firstName;
    @FindBy(xpath = "//input[contains(@analytics-id,'FA9C067A')]") public WebElement lastName;
    @FindBy(id = "inputEmailAddress") public WebElement emailAddress;
    @FindBy(id = "inputYourPhoneNumber") public WebElement phoneNumber;
    @FindBy(id = "inputDateOfIncident") public WebElement dateIncident;
    @FindBy(xpath = "//input[contains(@analytics-id, 'F22872FC')]") public WebElement policyNumber;
    @FindBy(xpath = "//input[contains(@analytics-id, '23719012')]") public WebElement policyHolderName;
    @FindBy(xpath = "//button[contains(@analytics-id, 'E9238117')]") public WebElement claimsLoginButton;

    /** verify if users can access new car sales page */
    //use claimsLink for first step
    @FindBy(xpath = "//a[contains(text(),'Auto Process')]") public WebElement autoProcess;
    @FindBy(xpath = "//p/a[contains(@href,'https://www.progressive.com/claims/faq/total-loss/')]") public WebElement totalLossLink;
    @FindBy(xpath = "//a[contains(@href,'https://www.progressive.com/car-shopping-service/')]") public WebElement carShoppingLink;
    @FindBy(xpath = "//a[contains(@href,'https://www.progressive.com/car-shopping-service/buy/')]") public WebElement carBuyLink;
    @FindBy(xpath = "//*[@id=\"qsButton\"]") public WebElement carBuySubmit;
    @FindBy(xpath = "//a[contains(@href,'/prices-new/makes/')]") public WebElement newCars;

    /** verify if users can access low-price used-car sales page */
    //Add only two webelements on new car sales page
    @FindBy(xpath = "//a[contains(@href,'/used-cars-for-sale/')]") public WebElement usedCars;
    @FindBy(xpath = "//h3[contains(text(),'Lowest Price')]") public WebElement lowPriceUsedCars;


    public void negativeLog(String userName, String passWord) throws InterruptedException {
        click(loginLink);
        Thread.sleep(3000);
        typeAndEnter(loginUserName,userName);typeAndEnter(loginPassword,passWord);}

    public void clickAndAreacode(String code){
        click(autoBar);typeAndEnter(autoQuote,code);
    }

    public void blancSearch(){submit(searchBar);
    }

    public void searchDropDown(String item){
        submit(searchBar);type(searchBar2,item);}

    public void searchItems(String item){
        type(searchBar,item);submit(searchBar);}

    public void autoInstruction(){
        click(claimsLink);click(autoInsurance);}

    public void claimsReport(){click(claimsLink);
        click(claimsView);click(reportClaim);
        click(claimsLogin);}

    public void claimsReportForm(String name1, String name2, String
            email, String phone,String incident,String policyNum, String name3){
        claimsReport(); type(firstName,name1);type(lastName,name2); type(emailAddress,email);
        type(phoneNumber,phone);type(dateIncident,incident); type(policyNumber,policyNum);
        type(policyHolderName,name3);click(claimsLoginButton);
    }
    public void buyOrSaleCar() throws InterruptedException {click(claimsLink);
        click(autoProcess);click(totalLossLink);click(carShoppingLink);
        click(carBuyLink);click(carBuySubmit);
        Thread.sleep(3000);
        click(newCars);}
    public void usedCars() throws InterruptedException {buyOrSaleCar();
        click(usedCars);click(lowPriceUsedCars);}
}