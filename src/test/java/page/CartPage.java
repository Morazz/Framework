package page;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.mustache.Value;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CartPage extends AbstractPage {

    private final int timeWait = 10;
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(className = "fc-subtotal__value")
    private WebElement subtotalValue;

    @FindBy(id = "fc-cart")
    private WebElement itemsInfo;

    @FindBy(id = "fc-cart--fixed-width")
    private WebElement itemsWithFreeItem;

    @FindBy(xpath= "//*[@id=\"fc-cart-form\"]/div[1]/div[2]/div/div[4]")
    private WebElement freeItem;

    @FindBy(className = "fc-cart__item__name")
    private WebElement itemsNames;

    @FindBy(className = "fc-action--checkout--button")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public CheckoutPage goToCheckoutPage() {
        logger.info("Going to checkout page");
        new WebDriverWait(driver, timeWait)
                .until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
        return new CheckoutPage(driver);
    }


    public boolean checkFreeGift() {
        logger.info("If price is more than 50 check if free item added");
        new WebDriverWait(driver, timeWait)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"fc-cart-form\"]/div[1]/div[2]/div/div[4]")));
        WebElement web = driver.findElement(By.xpath("//*[@id=\"fc-cart-form\"]/div[1]/div[2]/div/div[4]"));
        return web.isDisplayed();
    }

    @Override
    public CartPage openPage() {
        new WebDriverWait(driver, timeWait)
                .until(ExpectedConditions.textToBe(By.className("fc-subtotal__label"), "Subtotal"));
        return new CartPage(driver);
    }
}
