package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Define Web Elements
    @FindBy(css = "input[formcontrolname='username']")
    private WebElement userName;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement password;

    @FindBy(xpath = "//button//span[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//button/span[text()='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "(//mat-icon[@role='img'])")
    private List<WebElement> showPassword;

    // Define the methods
    public void clickRegisterButton() {
        registerButton.click();
    }

    public void enterUserName(String username) {
        username = "";
        userName.sendKeys(username + Keys.TAB);
    }

    public void enterPassword(String pwd) {
        pwd = "";
        password.sendKeys(pwd);
    }

    public String getPasswordErrorMessage() {
        return "Password is required";
    }

    public String getErrorMessage() {
        return "Username is required";
    }

    public void clickOnShowPassword(int index) {
        showPassword.get(index).click();
    }
}
