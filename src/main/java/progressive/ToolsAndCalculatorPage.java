package progressive;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolsAndCalculatorPage extends CommonAPI {
    /**Navigate to tools and calculator through resource*/
    @FindBy(css = "#resources")
    public WebElement resourcesButton;
    @FindBy(xpath = "//a[@href='https://www.progressive.com/resources/insurance-calculators-and-tools/']")
    public WebElement toolsAndCalculatorSelection;
    /**Car affordability calculator*/
    @FindBy(xpath = "//a[text()='Car affordability calculator']")
    public WebElement carAffordabilityCalculatorButton;
    @FindBy(xpath = "//input[@id='downPayment']")
    public WebElement inputDownPayment;
    @FindBy(xpath = "//input[@id='monthlyPayment']")
    public WebElement inputMonthlyPayment;
    @FindBy(xpath = "//input[@id='interestRate']")
    public WebElement inputInterestRate;
    @FindBy(xpath = "//input[@id='termMonths']")
    public WebElement inputTermMonths;
    @FindBy(xpath = "//button[text()='Calculate']")
    public WebElement calculateButton;
    /**Auto depreciation calculator*/
    @FindBy(xpath = "//a[@href='https://www.progressive.com/answers/car-depreciation-calculator/']")
    public WebElement carDepreciationCalculatorButton;
    @FindBy(xpath = "//select[@id='newUsed']")
    public WebElement optionNewUsed;
    @FindBy(xpath = "//input[@id='value']")
    public WebElement inputCarPurchasePrice;
    /**Result text: specifically the word Result*/
    @FindBy(xpath = "//h2[text()='Results']")
    public WebElement resultText;
    /**Validation text: complete explanation with stats*/
    @FindBy(xpath = "//p[@class='resultText']")
    public WebElement validationText;
    /**FeedBack Alert Message*/
    @FindBy(xpath = "//a[text()='No, thanks']") public WebElement declineAlert;


    public ToolsAndCalculatorPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    public void clickResourcesButton() {
        try{click(resourcesButton);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    public void clickToolsAndCalculator() {
        try{click(toolsAndCalculatorSelection);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    public void clickCarAffordabilityCalculatorButton() {
        try{click(carAffordabilityCalculatorButton);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    /**DECLINE ALERT
     * USE IN TRY AND CATCH BLOCK EVERYWHERE
     * */
    public void clickDeclineAlert() {click(declineAlert);}

    /**
     * Navigate to tools and calculator through resource
     *Use this as the background
     *  */
    public void navigateToCalculatorOptions() {
        try {
            clickResourcesButton();
        }catch(Exception ex){
            clickDeclineAlert();
        }
        try {
            clickToolsAndCalculator();
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    /**
     * Use car affordability calculator, to calculate your monthly payments.
     * */
    public void enterValuesToCalculateCarAffordability(String downPayment, String monthlyPayment, String interestRate, String termMonths ) {
        try {useDownPayment(downPayment);
        }catch(Exception ex){
            clickDeclineAlert();
        }
        try{useMonthlyPayment(monthlyPayment);
        }catch(Exception ex){
            clickDeclineAlert();
        }
        try{useInterestRate(interestRate);
        }catch(Exception ex){
            clickDeclineAlert();
        }
        try{useTermMonths(termMonths);
        click(calculateButton);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    /** DOWN PAYMENT */
    public void useDownPayment(String downPayment) {
        click(inputDownPayment);
        type(inputDownPayment, downPayment);
    }
    /** MONTHLY PAYMENT */
    public void useMonthlyPayment(String monthlyPayment) {
        click(inputMonthlyPayment);
        type(inputMonthlyPayment, monthlyPayment);
    }
    /** INTEREST RATE */
    public void useInterestRate(String interestRate) {
        click(inputInterestRate);
        type(inputInterestRate, interestRate);
    }
    /** TERM MONTHS */
    public void useTermMonths(String termMonths) {
        click(inputTermMonths);
        type(inputTermMonths, termMonths);
    }
    /**
     * Auto depreciation calculator
     * */
    public void clickCarDepreciationCalculator() {
        try {
            click(carDepreciationCalculatorButton);
        } catch (Exception ex) {
            clickDeclineAlert();
        }
    }
    public void useDepreciationCalculator(String condition) {
        try {
            selectFromDropdown(optionNewUsed, condition);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    public void enterValueToPurchasePrice(String price) {
        try{click(inputCarPurchasePrice);
        type(inputCarPurchasePrice, price);
        click(calculateButton);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    /** CALCULATE BUTTON */
    public void clickCalculateButton() {
        try{click(calculateButton);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    /**Result text: specifically the word Result*/
    public String getResultText() {
        return resultText.getText();
    }


}
