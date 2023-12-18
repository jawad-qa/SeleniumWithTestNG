package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.util.TimeUtils;

import java.time.Duration;
import java.util.Random;

import static base.BaseClass.driver;

public class Utils {

    public static void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(element));
    }

}
