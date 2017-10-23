package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.nio.file.FileSystems;

public class DriverUtil {

    private static final String projectPath = System.getProperty("user.dir");
    private static final String separator = FileSystems.getDefault().getSeparator();
    private static final String resourcesPath = projectPath + separator + "src" + separator + "main" + separator + "resources" + separator;
    public static final String GECKO_DRIVER_NAME = "webdriver.gecko.driver";
    public static final String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
    private static final DriverUtil driverUtil = new DriverUtil();
    private static WebDriver driver;

    private DriverUtil() {

    }

  

    public static DriverUtil getInstance() {
        return driverUtil;
    }

    private  void init() {
        String browser = System.getProperty("browser");
        try {
            switch (browser) {
                case "firefox":
                    System.setProperty(GECKO_DRIVER_NAME, resourcesPath + "geckodriver");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new FirefoxDriver();
                    // add
                    break;
                case "chrome":
                    //TODO: add  chromedriver to resources project
                    System.setProperty(CHROME_DRIVER_NAME, resourcesPath + "chromedriver");
                    driver = new ChromeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Not supported browser type or unknown");
            }
        } catch (Exception ex) {
            System.out.println("Failed to create Driver for " + browser);
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public WebDriver getDriver() {
        this.driver = init();
    }
    
      public void disposeDriver() {
        this.driver.quit();
    }


}
