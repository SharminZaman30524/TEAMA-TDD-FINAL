package progressive;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ReadFromExcel;

public class TestToolsAndCalculator extends CommonAPI {
    @Test(enabled = true)
    public void testCarAffordability () throws InterruptedException {
        ToolsAndCalculatorPage resources = new ToolsAndCalculatorPage(driver);
        for (int row = 1; row <= 3; row++) {
                resources.navigateToCalculatorOptions();
                resources.clickCarAffordabilityCalculatorButton();

            ReadFromExcel readFromExcel = new ReadFromExcel();

                String downPayment = readFromExcel.getValueFromCell("ProgressiveData", row, 0);
                String monthlyPayment = readFromExcel.getValueFromCell("ProgressiveData", row, 1);
                String interestRate = readFromExcel.getValueFromCell("ProgressiveData", row, 2);
                String termMonths = readFromExcel.getValueFromCell("ProgressiveData", row, 3);

            resources.enterValuesToCalculateCarAffordability(downPayment, monthlyPayment, interestRate, termMonths);
            Thread.sleep(5000);

            String expectedResultText = "Results";
            String actualResultText = resources.resultText.getText();
            Assert.assertEquals(actualResultText, expectedResultText);

        }
    }
    @Test(enabled = true)
    public void testAutoDepreciationNew() {
        ToolsAndCalculatorPage resources = new ToolsAndCalculatorPage(driver);

            resources.clickResourcesButton();
            resources.clickToolsAndCalculator();
            resources.clickCarDepreciationCalculator();

            resources.useDepreciationCalculator("New");
            resources.enterValueToPurchasePrice("20,000");

        Assert.assertTrue(checkDisplayed(resources.resultText));
    }
    @Test(enabled = true)
    public void testAutoDepreciationUsed() {
        ToolsAndCalculatorPage resources = new ToolsAndCalculatorPage(driver);

        resources.clickResourcesButton();
        resources.clickToolsAndCalculator();
        resources.clickCarDepreciationCalculator();

        resources.useDepreciationCalculator("Used");
        resources.enterValueToPurchasePrice("10,000");

        /*String expectedResultText = "Results";
        String actualResultText = resources.resultText.getText();
        Assert.assertEquals(actualResultText,expectedResultText);*/
        Assert.assertTrue(checkDisplayed(resources.resultText));

    }
}
