package test;

import org.testng.annotations.Test;
import page.cartPage.CartPage;
import page.productPage.ProductPage;
import service.TestDataReader;

import static org.assertj.core.api.Assertions.assertThat;
import static util.Resolver.resolvePrice;

public class CartTest extends CommonConditions {

    @Test
    public void addProductsTest() {
        CartPage cartPage = new ProductPage(driver)
                .openPage()
                .addProducts(TestDataReader.getTestData("test.data.count"))
                .goToCart();

        int amount = cartPage
                .getProductsAmount();
        double totalPrice = cartPage
                .getTotalPrice();

        assertThat(amount).isEqualTo(1);
        assertThat(totalPrice).isEqualTo(360.0);
    }

    @Test
    public void freeItemIfPriceIsFiftyOrGreaterTest() {
        CartPage cartPage = new ProductPage(driver)
                .openPage()
                .addProducts(TestDataReader.getTestData("test.data.count"))
                .goToCart();

        int amount = cartPage
                .getProductsAmount();
        double totalPrice = cartPage
                .getTotalPrice();
        boolean freeItem = cartPage
                .checkFreeGift();

        assertThat(amount).isEqualTo(TestDataReader.getTestData("test.data.cart.amount"));
        assertThat(totalPrice).isGreaterThanOrEqualTo(resolvePrice(TestDataReader.getTestData("test.data.cart.minprice")));
        assertThat(freeItem).isTrue();
    }

    @Test
    public void addBillingAddressOption() {
        boolean expectedBillingAddressState = new ProductPage(driver)
                .openPage()
                .addProducts(TestDataReader.getTestData("test.data.count"))
                .goToCart()
                .goToCheckoutPage()
                .billingAddressIsDisplayed();

        assertThat(expectedBillingAddressState).isTrue();
    }
}
