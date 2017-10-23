import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import page.HomePage;
import page.LoginPage;
import utils.Common;
import utils.DriverUtil;

import static org.junit.Assert.assertEquals;

public class LoginTests{

    private HomePage homePage;
    private LoginPage loginPage;
    private WebDriver driver;
    
    
    @BeforeClass
    public before(){
        driver = DriverUtil.getInstance().getDriver();
    }
    
    @AfterClass
    public before(){
        DriverUtil.getInstance().getDriver().dispose();
    }

    @Before
    public void setUp() {
        driver.get("https://meta.ua/");
        homePage = new HomePage(driver);
//        loginPage = new LoginPage(DriverUtil.getInstance().getDriver());
    }

    @After
    public void tearDown() {
        homePage = null;

    }

    @Test
    public void assertAuntificationWithCorrectCredentials() {
        homePage.setLogin("test20171022@meta.ua");
        homePage.setPassword("test123");
        Common.click(homePage.getEnterButton());
        String actualUserName = DriverUtil.getInstance().getDriver().findElement(By.xpath("//span[@id='face-change-tmp']//b")).getText();
        assertEquals("test20171022@meta.ua", actualUserName);
    }

    @Test
    public void assertIncorrectLoginValidation() {
        homePage.setLogin("Test");
        homePage.setPassword("test123");
        Common.click(homePage.getEnterButton());
        assertEquals(loginPage.getIncorrectPasswordMessage(), loginPage.getErrorMessage());
    }

    @Test
    public void assertIncorrectPasswordValidation() {
        homePage.setLogin("test20171022@meta.ua");
        homePage.setPassword("Test");
        Common.click(homePage.getEnterButton());
        assertEquals(loginPage.getIncorrectPasswordMessage(), loginPage.getErrorMessage());
    }

    @Test
    public void assertValidationWithoutCredentials() {
        Common.click(homePage.getEnterButton());
        assertEquals(loginPage.getIncorrectLoginMessage(), loginPage.getErrorMessage());
    }
}
