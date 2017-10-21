import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertTrue;

public class TestHomePage {
    
    WebDriver driver = new FirefoxDriver();
    private HomePage homePage;

    @BeforeClass
    public static void setSystemProperty() {
        System.setProperty("webdriver.gecko.driver", "/home/dimas/Documents/git/AutomationMeta/src/main/resources/geckodriver");
    }
    @Before
    public void init() {
        driver.get("https://meta.ua/");
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        homePage = null;
    }

    @Test
    public void testIsAllFieldsPresent() {
        assertTrue(homePage.getLoginField().isEnabled());

    }

}
