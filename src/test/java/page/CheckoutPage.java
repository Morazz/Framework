package page;

import model.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.TestDataReader;

import java.util.List;

import static page.abstractPages.AbstractPage.waitElementToBeClickable;
import static page.abstractPages.AbstractPage.waitElementVisibility;

public class CheckoutPage {
    private WebDriver driver;
int timeWait = 10;

    @FindBy(id = "use_different_addresses")
    private WebElement billingAddressOption;

    @FindBy(className = "fc-checkout__section--customer-billing-address")
    private WebElement billingAddressField;

    @FindBy(className = "fc-alert")
    private WebElement warning;

    @FindBy(xpath = "//*[@class='fc-alert fc-alert--danger show']")
    private WebElement getWarning;

    @FindBy(className = "fc-transaction__ui__toggle")
    private WebElement enterCouponButton;

    @FindBy(id = "coupon")
    private WebElement couponInput;

    @FindBy(className = "fc-coupon-entry__apply")
    private WebElement applyCouponButton;

    @FindBy(id = "cc_number")
    private WebElement cardNumber;

    @FindBy(id = "cc_exp_month")
    private WebElement expirationMonth;

    @FindBy(id = "cc_exp_year")
    private WebElement expirationYear;

    @FindBy(id = "cc_cvv2")
    private WebElement csc;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean billingAddressIsDisplayed() {
        waitElementToBeClickable(driver, billingAddressOption);
        if (!billingAddressOption.isSelected()) {
            billingAddressOption.click();
        }
        return billingAddressField.isDisplayed();
    }

    public String enterCouponCode(String couponCode) {
        enterCouponButton.click();
        waitElementToBeClickable(driver, couponInput);
        couponInput.sendKeys(couponCode);
        applyCouponButton.click();
        waitElementVisibility(driver, warning);
        return warning.getText();
    }

    //*[@id="fc-payment-method-plastic-new"]/div[2]

    public String enterCard() {
        cardNumber.click();
        cardNumber.sendKeys(TestDataReader.getTestData("test.data.card"));
        csc.click();
        csc.sendKeys(TestDataReader.getTestData("test.data.CSC"));
        csc.submit();
        waitElementVisibility(driver, getWarning);

        return getWarning.getText();
    }
}
