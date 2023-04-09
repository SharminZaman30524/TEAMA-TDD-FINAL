package progressive;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

public class CareersPage extends CommonAPI {

    @FindBy(xpath = "//a[@href='/careers/']")
    public WebElement careersButton;
    @FindBy(xpath = "//div[@class='button']//a[contains(text(),'View job openings')]")
    public WebElement viewJobOpeningsButton;
    @FindBy(xpath = "//tbody/tr/td/div/label/div[@class='checkboxp checkbox-unchecked']")
    public WebElement option;
    @FindBy(xpath = "//a[text()='Add']")
    public WebElement addButton;
    /** STATE*/
    @FindBy(xpath = "a[@id='LOCATION-seeallolf']")
    public WebElement seeAllLocations;
    @FindBy(xpath = "//input[@type='search']")
    public WebElement filterLocations;
    @FindBy(xpath = "//span[text()='Georgia']")
    public WebElement optionGeorgia;
    @FindBy(xpath = "//span[text()='California']")
    public WebElement optionCalifornia;
    @FindBy(xpath = "//tbody/tr//td[2]")
    public List<WebElement> stateLocation;
    @FindBy (xpath = "//ul[@id='filterList']/li")
    public WebElement stateSelectionResult;
    /** Job Type */
    @FindBy(xpath = "//a[@id='JOB_FIELD-seeallolf']")
    public WebElement seeAllJobField;
    @FindBy(xpath = "//input[@type='search']")
    public WebElement inputJobField;
    @FindBy(xpath = "//tbody//tr//td[1]")
    public List<WebElement> jobCategoryPostings;
    /** Search using keyword*/
    @FindBy(xpath = "//input[@id='KEYWORD']")
    public WebElement inputKEYWORD;
    @FindBy(xpath = "//a[text()='No, thanks']") public WebElement declineAlert;


    public CareersPage(WebDriver driver) {PageFactory.initElements(driver,this);}
    /**
     * Navigate to the careers pages
     * Use as background for all careers test cases
     */
    public void clickOnCareersPage() {
            try{click(careersButton);
            }catch(Exception ex){
                clickDeclineAlert();
            }
        }
    public void clickOnViewJobOpenings() {
        try{click(viewJobOpeningsButton);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    /**DECLINE ALERT
     * USE IN TRY AND CATCH BLOCK EVERYWHERE
     * */
    public void clickDeclineAlert() {click(declineAlert);}

    /**
     * Use the side filters to search the job openings for a specific state: Georgia
     */
    public void clickSeeAllLocations() {
        try{click(seeAllLocations);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    public void enterStateInFilterLocations(String state) {
        try{
            type(filterLocations,state);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    public void clickCaliforniaOption() {
        try{click(optionCalifornia);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    public void selectStateFilter(String state) {
        clickOnCareersPage();
        clickOnViewJobOpenings();
        clickSeeAllLocations();
        enterStateInFilterLocations(state);
        clickAddButton();
    }
    public String getStateSelectionResult() {
        return stateSelectionResult.getText();
    }
    public void selectCaliforniaStateFilter() {
        clickOnCareersPage();
        clickOnViewJobOpenings();
        clickCaliforniaOption();
    }
    public List<String> listOfCaliforniaLocations() {
        List<String> listCalifornia = new LinkedList<>();
        for (WebElement element: stateLocation){
            listCalifornia.add(element.getText());
        }
        return listCalifornia;
    }
    public List<String> listOfGeorgiaLocations() {
        List<String> listGeorgia = new LinkedList<>();
        for (WebElement element: stateLocation){
            listGeorgia.add(element.getText());
        }
        return listGeorgia;
    }
    /**
     * Use the side filters to search the job openings for Job category: Sales
     */
    public void clickSeeAllJobField() {
        try{click(seeAllJobField);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    public void enterValueInJobField(String job) {
        try{type(inputJobField,job);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    public void clickAddButton() {
        try{click(addButton);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    public void selectSalesJobCategoryFilter(String job) {
        clickOnCareersPage();
        clickOnViewJobOpenings();
        clickSeeAllJobField();
        enterValueInJobField(job);
        clickAddButton();
    }
    public List<String> listOfSalesPositions() {
        List<String> listSale = new LinkedList();
        for (WebElement element: jobCategoryPostings){
            listSale.add(element.getText());
        }
        return listSale;
    }
    /**
     * Use the search KEYWORD input field to search a career of choice: engineer
     */
    public void enterCareerInKEYWORD(String career){
        try{typeAndEnter(inputKEYWORD,career);
        }catch(Exception ex){
            clickDeclineAlert();
        }
    }
    public void searchUsingKEYWORD(String career) {
        clickOnCareersPage();
        clickOnViewJobOpenings();
        enterCareerInKEYWORD(career);
    }
    public List<String> listOfPositionsUsingKeyword() {
        List<String> listEngineer = new LinkedList();
        for (WebElement element: jobCategoryPostings){
            listEngineer.add(element.getText());
        }
        return listEngineer;
    }

}

