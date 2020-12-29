package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.abstractPages.AbstractPage;

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

    @Override
    public ProductPage openPage() {
        driver.navigate().to(PRODUCTPAGE_URL);
        return this;
    }
}
