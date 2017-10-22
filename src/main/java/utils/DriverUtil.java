package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverUtil {

    private static final DriverUtil driverUtil = new DriverUtil();
    private static WebDriver driver;

    private DriverUtil(){

    }
    static {
        init();
    }


    public static DriverUtil getInstance(){
        return driverUtil;
    }

    public final WebDriver getDriver() {
        return driver;
    }

    private static void init() {
        String browser = System.getProperty("browser");
     //add try catch
        switch (browser) {
            case "firefox":
//                System.setProperty("webdriver.gecko.driver", Common.getResoursesPath() + "geckodriver");
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver();
                // add
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Not supported browser type or unknown");
        }
    }



}
