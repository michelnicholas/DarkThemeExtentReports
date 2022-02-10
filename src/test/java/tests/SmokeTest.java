package tests;

import base.UiTestBase;
import com.github.dockerjava.api.model.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.DriverUtil;

public class SmokeTest extends UiTestBase {

    @Test
    public void isHomepageDisplayed(){
        home().open();
        boolean result = home().isHomePageDisplayed();
        Assert.assertTrue(result);
        home().close();
    }








}
