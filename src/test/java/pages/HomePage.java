package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.DriverUtil;

public class HomePage extends DriverUtil {


    private static String url = "http://saucedemo.com";
    private static By page_banner_text = By.xpath("//div[@id='root']//div[@class='login_logo']");



    public static boolean isHomePageDisplayed(){
        driver().get(url);
        WebElement pageBanner = driver().findElement(page_banner_text);
        Boolean isPageBannerDisplayed = pageBanner.isDisplayed();
        return pageBanner.isDisplayed();
    }


}
