package test;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import page.CartPage;
import page.ProductPage;
import service.TestDataReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartTest extends CommonConditions {
    private final String productsAmount = "100";

    @Test
    public void addProductsTest() {
        CartPage cartPage = new ProductPage(driver)
                .openPage()
                .addProducts(productsAmount)
                .goToCart();

        int amount = cartPage
                .getProductsAmount();
        double totalPrice = cartPage
                .getTotalPrice();

        assertThat(amount).isEqualTo(2);
        assertThat(totalPrice).isEqualTo(360.0);
    }

    @Test
    public void freeItemIfPriceIsFiftyOrGreaterTest() {
        CartPage cartPage = new ProductPage(driver)
                .openPage()
                .addProducts(productsAmount)
                .goToCart();

        int amount = cartPage
                .getProductsAmount();
        double totalPrice = cartPage
                .getTotalPrice();
        boolean freeItem = cartPage
                .checkFreeGift();

        assertThat(amount).isEqualTo(2);
        assertThat(totalPrice).isGreaterThanOrEqualTo(50.00);
        assertThat(freeItem).isTrue();
    }

    @Test
    public void addBillingAddressOption() {
        boolean expectedBillingAddressState = new ProductPage(driver)
                .openPage()
                .addProducts(productsAmount)
                .goToCart()
                .goToCheckoutPage()
                .billingAddressIsDisplayed();

        assertThat(expectedBillingAddressState).isTrue();
    }

    public void enterInvalidCouponCodeTest() {
        ProductPage productPage = new ProductPage(driver)
                .openPage()
                .addProducts(productsAmount);
        String expectedMessage = productPage
                .goToCart()
                .goToCheckoutPage()
                .enterCouponCode(TestDataReader.getTestData("test.data.promocode"));

        assertThat(expectedMessage).isEqualTo(TestDataReader.getTestData("test.data.coupon.error"));
    }
}
