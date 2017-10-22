package utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Common {


    private static WebDriver driver;

    public static void click(WebElement element){
        element.click();
    }

    public static void waitForElementToAppear(WebElement element, long timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(
                    ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new IllegalStateException("element is not appeared");
        }
    }

    public static void checkExpectedPage(String pageUrl) {
        if (!driver.getCurrentUrl().contains(pageUrl)) {
            System.out.println("Current url: "+ driver.getCurrentUrl());
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
    }
}
