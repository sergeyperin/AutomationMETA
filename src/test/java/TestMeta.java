import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestMeta {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/home/dimas/Documents/git/AutomationMeta/src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
//        driver.get("http://passport.meta.ua/?mode=reg&ref=main");
//        RegistrationPage test = new RegistrationPage(driver);
        driver.get("https://passport.meta.ua/");
        LoginPage test = new LoginPage(driver);


//      test.setFirstName("test");
//      test.setLastName("test");
      test.setLogin("test");
      test.setPassword("test");
      test.clickOnEnterButton();
//      test.setConfirmPassword("test");
//      test.clickOnCapcha();

//        System.out.println(test.isAgreementCheckboxChecked());
//      test.clickOnAgreementCheckbox();
//      test.clickOnRegisterButton();

    }
}
