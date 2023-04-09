package progressive;
import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class BundleListOption extends CommonAPI {
    public BundleListOption(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    /**
     * WebElements
     **/
    @FindBy(xpath = "//div[@data-module='content-image']//div//h3//a[@href='/insurance/bundling/']")
    public WebElement bundleAndPropertyButton;
    @FindBy(xpath = "(//div[normalize-space()='Homeowners'])[1]")
    public WebElement bundleArea;
    @FindBy(xpath = "(//button[@id='s-au+c'])[1]")
    public WebElement condoOption;
    @FindBy(xpath = "(//ul[@role='listbox'])[3]")
    public List<WebElement> bundleOptions;
    /**
     * Steps associated with each method
     */
    public void clickBundleNPropertyButton() {
        click(bundleAndPropertyButton);
    }
    public void clickBundleArea() {
        click(bundleArea);
    }
    public void selectCondoOption() {
        for (WebElement i : bundleOptions) {
            if (i == condoOption) {
                click(condoOption);
                break;
            }
        }
    }
    /**
     * Test case to validate the bundle dropdown after selecting "Bundle auto & property"
     */
    public void bundleDropdownFeatureMethod() {
        clickBundleNPropertyButton();
        try{cancelAlert();}
        catch (Exception e){
            System.out.println("Caught");

        }
        clickBundleArea();
        selectCondoOption();
    }
}