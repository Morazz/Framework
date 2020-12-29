package page.checkoutPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractPage;
import service.TestDataReader;

import static util.Resolver.resolveTotalPrice;

public class CheckoutPage extends AbstractPage {
    private WebDriver driver;

    @FindBy(id = "use_different_addresses")
    private WebElement billingAddressOption;

    @FindBy(className = "fc-checkout__section--customer-billing-address")
    private WebElement billingAddressField;

    @FindBy(className = "fc-alert")
    private WebElement warning;

    @FindBy(xpath = "//*[@class='fc-alert fc-alert--danger show']")
    private WebElement getWarning;

    @FindBy(className = "fc-subtotal__value")
    private WebElement subtotalValue;

    @FindBy(className = "fc-transaction__ui__toggle")
    private WebElement enterCouponButton;

    @FindBy(id = "coupon")
    private WebElement couponInput;

    @FindBy(className = "fc-coupon-entry__apply")
    private WebElement applyCouponButton;

    @FindBy(id = "cc_number")
    private WebElement cardNumber;

    @FindBy(id = "cc_cvv2")
    private WebElement csc;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean billingAddressIsDisplayed() {
        waitElementToBeClickable(billingAddressOption);
        if (!billingAddressOption.isSelected()) {
            billingAddressOption.click();
        }
        return billingAddressField.isDisplayed();
    }

    public String enterCouponCode(String couponCode) {
        enterCouponButton.click();
        waitElementToBeClickable(couponInput);
        couponInput.sendKeys(couponCode);
        applyCouponButton.click();
        waitElementVisibility(warning);
        return warning.getText();
    }

    public double getTotalPrice() {
        return resolveTotalPrice(subtotalValue.getText());
    }

    public String enterCard() {
        cardNumber.click();
        cardNumber.sendKeys(TestDataReader.getTestData("test.data.card"));
        csc.click();
        csc.sendKeys(TestDataReader.getTestData("test.data.CSC"));
        csc.submit();
        waitElementVisibility(getWarning);

        return getWarning.getText();
    }
}
