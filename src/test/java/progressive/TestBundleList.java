package progressive;
import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBundleList extends CommonAPI {
    @Test(enabled = false)
    public void bundleOptionTest()  {
        windowMaximize();
        BundleListOption bundle = new BundleListOption(driver);
        bundle.bundleDropdownFeatureMethod();
        if(bundle.condoOption.isSelected()){
            Assert.assertTrue(true);
        }
    }
}