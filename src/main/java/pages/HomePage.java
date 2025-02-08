package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button/span[normalize-space(text())='Login']")
    private WebElement loginLink;

    @FindBy(css = "input[type='search']")
    private WebElement searchBox;

    @FindBy(xpath = "//span[normalize-space(text())='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(css = "span.mdc-list-item__content")
    private List<WebElement> bookCategories;

    @FindBy(css = "div.card-title")
    private List<WebElement> bookTitles;

    @FindBy(css = "mat-card-content>p")
    private List<WebElement> bookPrices;

    @FindBy(css = "div[role='listbox']")
    private WebElement autocompleteListItem;

    @FindBy(css = "div.card-deck-container>div")
    private List<WebElement> bookCount;

    @FindBy(css = "#mat-badge-content-0")
    private WebElement cartCount;

    // Define the methods

    public void clickLoginLink() {
        loginLink.click();
    }

    public void searchBook(String bookName) {
        searchBox.sendKeys(bookName);
        if (autocompleteListItem.isDisplayed()) {
            System.out.println("Autocomplete list is displayed");
            autocompleteListItem.click();
        }
    }

    public int getBookCount() {
        return bookCount.size();
    }

    public void getBooksByCategory(String category) {
        for (WebElement bookCategory : bookCategories) {
            if (bookCategory.getText().equals(category)) {
                bookCategory.click();
                break;
            }
        }

    }

    public String getBookTitle(String bookName) {
        System.out.println("bookName is " + bookName);
        for (WebElement bookTitle : bookTitles) {
            System.out.println("bookTitle is " + bookTitle.getText().toLowerCase());
            if (bookTitle.getText().toLowerCase().equals(bookName)) {
                return bookTitle.getText().toLowerCase();
            }
        }
        return null;
    }

    public void addBookToCart() {
        addToCartButton.click();
    }

    public int getCartCount() {
        return Integer.parseInt(cartCount.getText());
    }

    public void clickOnLoginLink() {
        loginLink.click();
    }
}
