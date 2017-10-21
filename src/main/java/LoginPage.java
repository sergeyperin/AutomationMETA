import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private static String URL_MATCH = "https://passport.meta.ua/";
    private WebDriver driver;

    @FindBy(id = "login")
    private WebElement loginField;

    @FindBy(xpath = "//input[contains(@name, 'password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[contains(@value, 'Войти')]")
    private WebElement enterButton;

    LoginPage(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(URL_MATCH)) {
            System.out.println("Current url: "+ driver.getCurrentUrl());
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setLogin(String login) {
        loginField.sendKeys(login);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnEnterButton() {
        enterButton.click();
    }
}
