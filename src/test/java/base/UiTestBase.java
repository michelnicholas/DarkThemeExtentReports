package base;

import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import utility.DriverUtil;
import utility.TestListener;

public class UiTestBase {
    // Test Base is for all pages

    private HomePage home;


    @BeforeMethod
    public void setUp(){
        DriverUtil.open();
    }

    @AfterMethod
    public void cleanUp(){
        DriverUtil.close();
    }




    protected HomePage home(){
        if (home == null){
            home = new HomePage();
            return home;
        }
        return home;
    }


    public String username(){
        return new Faker().name().username();
    }



}
