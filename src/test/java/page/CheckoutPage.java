package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private WebDriver driver;
    private final int timeWait = 10;

    @FindBy(name = "use_different_addresses")
    private WebElement billingAddressOption;

    @FindBy(className = "fc-checkout__section--customer-billing-address")
    private WebElement billingAddressField;

    @FindBy(className = "fc-alert")
    private WebElement warning;

    @FindBy(className = "fc-transaction__ui__toggle")
    private WebElement enterCouponButton;

    @FindBy(id = "coupon")
    private WebElement couponInput;

    @FindBy(className = "fc-coupon-entry__apply")
    private WebElement applyCouponButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkBillingAddressState() {
        if (!billingAddressOption.isSelected()) {
            billingAddressOption.click();
        }
        return billingAddressField.isDisplayed();
    }

    public String enterCouponCode(String couponCode) {
        enterCouponButton.click();
        new WebDriverWait(driver, timeWait)
                .until(ExpectedConditions.elementToBeClickable(couponInput));
        couponInput.sendKeys(couponCode);
        applyCouponButton.click();
        new WebDriverWait(driver, timeWait)
                .until(driver -> warning.isDisplayed());
        return warning.getText();
    }
}
