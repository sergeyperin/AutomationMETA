import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.HomePage;
import page.LoginPage;
import utils.Common;
import utils.DriverUtil;

public class Test {

    public static void main(String[] args) {

//        String browser = "firefox";

        System.setProperty("webdriver.gecko.driver", "/home/dimas/Documents/git/AutomationMeta/src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
//        driver.get("http://passport.meta.ua/?mode=reg&ref=main");
//        page.RegistrationPage test = new page.RegistrationPage(driver);
        driver.get("http://meta.ua/");
        HomePage test = new HomePage(driver);


//      test.setFirstName("test");
//      test.setLastName("test");
      test.setLogin("test");
      test.setPassword("test");
        Common.click(test.getEnterButton());
//      test.setConfirmPassword("test");
//      test.clickOnCapcha();

//        System.out.println(test.isAgreementCheckboxChecked());
//      test.clickOnAgreementCheckbox();
//      test.clickOnRegisterButton();

    }
}
