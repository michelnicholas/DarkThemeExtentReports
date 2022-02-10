package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {

    private static WebDriver driver;


    public static void open(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public static WebDriver driver(){
        if (driver == null){
            open();
            return driver;
        }
        return driver;
    }



    public static void close(){
        if (driver == null){
        driver.quit();
        }


    }



}
