import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private static String URL_MATCH = "http://passport.meta.ua/?mode=reg&ref=main";

    private WebDriver driver;

    @FindBy(xpath = "//strong[contains(.//a, 'ПАСПОРТ')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='regged']/a")
    private WebElement loginLink;

    @FindBy(xpath = "//div[contains(.//label, 'Имя')]//input")
    private WebElement firstNameField;

    @FindBy(xpath = "//div[contains(.//label, 'Фамилия')]//input")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[contains(.//label, 'Логин')]//input")
    private WebElement loginField;

    @FindBy(xpath = "//div[contains(.//label, 'Пароль')]//input")
    private WebElement passwordField;

    @FindBy(xpath = "//div[contains(.//label, 'Повторите пароль')]//input")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//span[@id='recaptcha-anchor']")
    private WebElement capcha;

    @FindBy(xpath = "//input[@id='check_agree']")
    private WebElement AgreementCheckbox;

    @FindBy(id = "register_btn")
    private WebElement registerButton;

    RegistrationPage(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(URL_MATCH)) {
            System.out.println("Current url: "+ driver.getCurrentUrl());
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void setLogin(String login) {
        loginField.sendKeys(login);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickOnCapcha() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title, 'виджет reCAPTCHA')]")));
        capcha.click();;
    }

    public void clickOnAgreementCheckbox() {
        AgreementCheckbox.click();
    }
    public Boolean isAgreementCheckboxChecked() {
        return AgreementCheckbox.isSelected();
    }
//    it can subtitude clickOnAgreementCheckbox() and isAgreementCheckboxChecked().
    public void setAgreementCheckboxChecked() {
        if (!AgreementCheckbox.isSelected())
            AgreementCheckbox.click();
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }


}
