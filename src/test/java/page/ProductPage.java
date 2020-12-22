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
    private final int timeWait = 10;

    @FindBy(name = "quantity")
    private WebElement productsQuantity;

    @FindBy(className = "add_button")
    private WebElement addButton;

    @FindBy(className = "fc-fixed-button-right")
    private WebElement cartLink;

    @FindBy(id = "fc")
    private WebElement cartPreview;

    @FindBy(xpath= "//*[@id=\"fc-cart-form\"]/div[1]/div[2]/div/div[4]")
    private WebElement freeItem;


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

    public boolean checkFreeGift() {
        //return itemsInfo.findElements(By.id("fc-cart--fixed-width")).size() > 0;
        new WebDriverWait(driver, timeWait)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='fc-cart-form']/div[1]/div[2]/div/div[4]")));
        return freeItem.isDisplayed();
    }

    public CartPage goToCart() {
        new WebDriverWait(driver, timeWait)
                .until(ExpectedConditions.textToBe(By.className("fc-subtotal__label"), "Subtotal"));
        //cartLink.click();
        return new CartPage(driver);
    }


    @Override
    public ProductPage openPage() {
        driver.navigate().to(PRODUCTPAGE_URL);
        return this;
    }
}
