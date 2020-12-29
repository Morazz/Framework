package page.cartPage;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.apache.logging.log4j.Logger;
import page.AbstractPage;
import page.checkoutPage.CheckoutPage;

import static util.Resolver.resolvePrice;
import static util.Resolver.resolveTotalPrice;

public class CartPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(className = "fc-subtotal__value")
    private WebElement subtotalValue;

    @FindBy(css= "div[data-item-code=\"FreeGift50\"]")
    private WebElement freeItem;

    @FindBy(className = "fc-action--checkout--button")
    private WebElement checkoutButton;

    @FindBy(name = "item_count")
    private WebElement itemsCount;

    public CartPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
    }

    public CheckoutPage goToCheckoutPage() {
        logger.info("Going to checkout page");
        waitElementVisibility(checkoutButton).click();
        //checkoutButton.click();
        return new CheckoutPage(driver);
    }

     public boolean checkFreeGift() {
        logger.info("Check if free item added");
        return freeItem.isEnabled();
    }

    public int getProductsAmount() {
        waitElementToBeClickable(freeItem);
        return Integer.parseInt(itemsCount.getAttribute("value"));
    }

    public double getTotalPrice() {
        return resolveTotalPrice(subtotalValue.getText());
    }

    public CartPage openPage() {
        return new CartPage(driver);
    }
}
