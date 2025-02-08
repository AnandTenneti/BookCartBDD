package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Define Web Elements
    @FindBy(css = "input[formcontrolname='firstName']")
    private WebElement firstName;

    @FindBy(css = "input[formcontrolname='lastName']")
    private WebElement lastName;

    @FindBy(css = "input[formcontrolname='userName']")
    private WebElement userName;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement password;

    @FindBy(css = "input[formcontrolname='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(css = "input[name='mat-radio-group-0']")
    private List<WebElement> gender;

    @FindBy(xpath = "//button//span[normalize-space(text())='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//button/span[text()='Login']")
    private WebElement loginButton;

    @FindBy(css = "mat-error#mat-mdc-error-0")
    private WebElement userNameNotAvailableErrorMessage;
    @FindBy(css = "mat-error#mat-mdc-error-1")
    private WebElement passwordValidationErrorMessage;

    @FindBy(css = "mat-error#mat-mdc-error-2")
    private WebElement confirmPasswordValidationMessage;

    @FindBy(css = "div.mat-mdc-form-field-icon-suffix>mat-icon[role='img']")
    private List<WebElement> showPassword;


    // Define the methods
    public void enterFirstName(String fName) {
        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        lastName.sendKeys(lName);
    }

    public void enterUserName(String uName) {
        userName.sendKeys(uName);
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void enterConfirmPassword(String pwd) {
        confirmPassword.sendKeys(pwd);
    }

//    public String getValidationMessage() {
//        return userNameNotAvailableError.getText();
//    }
//    public String getPasswordErrorMessage() {
//        return userNameNotAvailableError.getText();
//    }

    public String getValidationMessage(String fieldName) {
        switch (fieldName) {
            case "username":
                return userNameNotAvailableErrorMessage.getText();
            case "Password":
                return passwordValidationErrorMessage.getText();
            case "confirmPassword":
                return confirmPasswordValidationMessage.getText();
            default:
                return "Invalid field name";
        }
    }

    public void clickOnShowPassword(int index) {
        showPassword.get(index).click();
    }
}

