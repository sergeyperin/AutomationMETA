import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static String URL_MATCH = "https://meta.ua/";
    private WebDriver driver;

    @FindBy(xpath = "//input[contains(@name, 'login')]")
    private WebElement loginField;

    @FindBy(xpath = "//input[contains(@name, 'password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[contains(@value, 'Войти')]")
    private WebElement enterButton;

    @FindBy(id = "mainQ")
    private WebElement searchField;

    @FindBy(id = "sb")
    private WebElement searchButton;

    HomePage(WebDriver driver) {
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

    public WebElement getLoginField() {
        return loginField;
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnEnterButton() {
        enterButton.click();
    }

    public void doSearch(String text) {
        searchField.sendKeys(text);
        searchButton.click();
    }
}
