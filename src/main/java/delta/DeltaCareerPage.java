package delta;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

public class DeltaCareerPage extends CommonAPI {
    /**Search now button*/
    @FindBy (xpath = "//button[@class='submitButton']") public WebElement searchNowButton;

    /**Locators for state: Location*/
    @FindBy (xpath ="//span[@class='select2-selection__arrow']") public WebElement locationDropDown;
    @FindBy (xpath ="//input[@class='select2-search__field']") public WebElement searchLocationDropDown;
    @FindBy (xpath ="//span[@class='select2-results']") public WebElement resultLocationDropDown;
    @FindBy (xpath = "//span[text()='United States, New York, New York.']" ) public List<WebElement> resultsNewYorkLocation;

    /**Locators for engineer: Keyword search*/
    @FindBy (xpath = "//input[@class=' TextField WizardFieldInputContainer WizardFieldInput']")
    public WebElement inputKeyword;
    @FindBy (xpath = "//div[@class='list__item__text__title']" )
    public List<WebElement> resultsEngineer;

    /**Locators for Finance and Accounting: Job Category*/
    @FindBy (xpath = "//select[@name='2884']") public WebElement selectJobCategory;
    @FindBy (xpath = "//div[@class='list__item__text__title']" )
    public List<WebElement> resultsJobCategory;

    public DeltaCareerPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    /**Click search now button*/
    public void clickSearchNow() {
        click(searchNowButton);
    }
    /**Location by state*/
    public void clickLocationDropdown() {
        click(locationDropDown);
    }
    public void enterStateInDropdownSearchBar(String location) {type(searchLocationDropDown, location);}
    public void clickStateResultDropdown(){
        click(resultLocationDropDown);
    }
    public List <String> getNewYorkResults() {
        List<String> getNewYorkResults = new LinkedList<>();
        for(WebElement newYork : resultsNewYorkLocation){
            getNewYorkResults.add(getTextFromWebElement(newYork));
        } return getNewYorkResults;
    }
    /**Keyword search: engineer*/
    public void putCareerKeyword(String career) {
        type(inputKeyword, career);}
    public void enterCareerKeyword(String career) {
        type(inputKeyword, career);
        clickSearchNow();}
    public List <String> getEngineerResults() {
        List<String> getEngineerResults = new LinkedList<>();
        for(WebElement engineer : resultsEngineer){
            getEngineerResults.add(getTextFromWebElement(engineer));
        } return getEngineerResults;
    }
    /**Job category: Finance and Accounting*/
    public void clickJobCategory() {click(selectJobCategory);}
    public void selectJobCategory(String career) {selectFromDropdown(selectJobCategory, career);}
    public void useJobCategory(String career) {
        clickJobCategory();
        selectJobCategory(career);
        clickSearchNow();
    }
    public List <String> getJobCategoryResults() {
        List<String> getCategoryResults = new LinkedList<>();
        for(WebElement category : resultsJobCategory){
            getCategoryResults.add(getTextFromWebElement(category));
        } return getCategoryResults;
    }



}
