package progressive;

import base.CommonAPI;
import org.apache.poi.hssf.record.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.priority;

public class TestClaims extends CommonAPI {
    static ClaimsPage claimsPage;
    public static void getInitElements() {
        claimsPage = PageFactory.initElements(driver, ClaimsPage.class);
    }

    @Test(priority = 1, testName = "claims 1")
    public void attemptLogin() throws InterruptedException {
        getInitElements();
        claimsPage.negativeLog("Armi","Armi");
        Thread.sleep(3000);

        WebElement loginErrorBox = driver.findElement(By.xpath("//ps-flyout-error/div[contains(text(),'The login information')] "));
        String errorMessage = loginErrorBox.getText();
        Assert.assertTrue(errorMessage.startsWith("The login"));

    }

    @Test(priority = 2, testName = "claims 2")
    public void autoQuote() {
        getInitElements();
        claimsPage.clickAndAreacode("30084");
    }

    @Test(priority = 3, testName = "claims 3")
    public void  blancInputSearch() throws InterruptedException {
        getInitElements();
        claimsPage.blancSearch();
        WebElement errorMessage = driver.findElement(By.className("returnedResults"));
        Thread.sleep(2000);
        Assert.assertTrue(errorMessage.isDisplayed());
    }
    @Test(priority = 4, testName="claims 4")
    public void searchingDropDown(){
        getInitElements();
        claimsPage.searchDropDown("Car Insurance");

    }
    @Test(priority = 5, testName = "claim 5")

    public void searchItems(){
        getInitElements();
        claimsPage.searchItems("Car Insurance");
    }
    @Test(priority = 6, testName = "claims 6")

    public void autoInsuranceInstruction(){
        getInitElements();
        claimsPage.autoInstruction();
    }
    @Test(priority = 7, testName = "claims 7")

    public void claimsReportLogin(){
        getInitElements();
        claimsPage.claimsReport();
    }
    @Test(priority = 8, testName = "claims 8")

    public void claimsReportFormFields() throws InterruptedException {
        getInitElements();
        claimsPage.claimsReportForm("John","Doe","email@email.com",
                "1234567892", "07/12/2022","1234567","Micheal");
        Thread.sleep(3000);

        WebElement loginErrorBox = driver.findElement(By.xpath("//pui-top-message[contains(@type,'error')]"));
        String errorText = loginErrorBox.getText();
        Assert.assertTrue(errorText.contains("Hmm,"));

    }
    @Test(priority = 9, testName = "claims 9")

    public void buyOrSaleCars() throws InterruptedException {
        getInitElements();
        claimsPage.buyOrSaleCar();

        String newCarsPageTitle = driver.getTitle();
        Assert.assertTrue(newCarsPageTitle.equalsIgnoreCase("New cars - progressive"));

    }

    @Test(priority = 10, testName = "claims 10",enabled = false)
    public void lowPriceUsedCars() throws InterruptedException {
        getInitElements();
        claimsPage.usedCars();

        String usedCarsPageTitle = driver.getTitle();
        Assert.assertTrue(usedCarsPageTitle.equalsIgnoreCase("Used Cars for Sale Online Near Me - Progressive"));

    }

}