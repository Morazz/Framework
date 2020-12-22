package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest extends CommonConditions {
    private final String productsAmount = "100";

    @Test
    public void addProductsTest() {
        boolean expectedCartState = new ProductPage(driver)
                .openPage()
                .addProducts(productsAmount)
                .goToCart()
                .checkFreeGift();
        Assert.assertTrue(expectedCartState);
        assertThat(expectedCartState).isTrue();
    }

    @Test
    public void addBillingAddressOption() {
        boolean expectedBillingAddressState = new ProductPage(driver)
                .openPage()
                .addProducts(productsAmount)
                .goToCart()
                .goToCheckoutPage()
                .checkBillingAddressState();
        assertThat(expectedBillingAddressState).isTrue();
    }
}
