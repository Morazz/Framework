package page.productPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractPage;
import page.cartPage.CartPage;

public class ProductPage extends AbstractPage {
    private final String PRODUCTPAGE_URL = "https://demeterfragrance.com/sandalwood.html";

    @FindBy(name = "quantity")
    private WebElement productsQuantity;

    @FindBy(className = "add_button")
    private WebElement addButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ProductPage addProducts(String quantityQuery) {
        productsQuantity.click();
        productsQuantity.sendKeys(quantityQuery);
        addButton.click();
        return this;
    }

    public CartPage goToCart() {
        return new CartPage(driver);
    }

    public ProductPage openPage() {
        driver.navigate().to(PRODUCTPAGE_URL);
        return this;
    }
}
