package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Common;

public class HomePage {

    private String pageURL = "http://meta.ua/";
    private WebDriver driver;

    @FindBy(xpath = "//input[contains(@name, 'login')]")
    private WebElement loginField;

    @FindBy(xpath = "//input[contains(@name, 'password')]")
    private WebElement passwordField;

    @FindBy(id = "lifetime")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//input[contains(@value, 'Войти')]")
    private WebElement enterButton;

    @FindBy(xpath = "//a[contains(text(), 'Забыли пароль')]")
    private WebElement forgetPassLink;

    @FindBy(xpath = "//a[contains(text(), 'Регистрация')]")
    private WebElement registerLink;

    @FindBy(id = "mainQ")
    private WebElement searchField;

    @FindBy(id = "sb")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
//        Common.checkExpectedPage(pageURL);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int isElementPresent(By element) {
        return driver.findElements(element).size();
    }

    public void setLogin(String login) {
        loginField.sendKeys(login);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public WebElement getEnterButton() {
        return enterButton;
    }

//    public void clickOnEnterButton() {
//        enterButton.click();
//    }

    public void doSearch(String text) {
        searchField.sendKeys(text);
        searchButton.click();
    }
}
