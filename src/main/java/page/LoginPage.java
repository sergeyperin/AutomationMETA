package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private static String pageUrl = "https://passport.meta.ua/";
    private WebDriver driver;
    private String incorrectLoginMessage = "Неверное имя пользователя";
    private String incorrectPasswordMessage = "";

    @FindBy(id = "login")
    private WebElement loginField;

    @FindBy(xpath = "//input[contains(@name, 'password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[contains(@value, 'Войти')]")
    private WebElement enterButton;

    @FindBy(xpath = "//div[@id='b3_cnt']/center/b")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(pageUrl)) {
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

    public String getErrorMessage() {
       return errorMessage.getText();
    }

    public String getIncorrectLoginMessage() {
        return incorrectLoginMessage;
    }

    public String getIncorrectPasswordMessage() {
        return incorrectPasswordMessage;
    }
}
