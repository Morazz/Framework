package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;
import page.ProductPage;

public class CartTest extends CommonConditions {
    private final String productsAmount = "100";

    @Test
    public void addProductsTest() {
        boolean expectedCartState = new ProductPage(driver)
                .openPage()
                .addProducts(productsAmount)
                .checkFreeGift();
        Assert.assertTrue(expectedCartState);
    }

    @Test
    public void addBillingAddressOption() {
        boolean expectedBillingAddressState = new ProductPage(driver)
                .openPage()
                .addProducts(productsAmount)
                .goToCart()
                .goToCheckoutPage()
                .checkBillingAddressState();
        Assert.assertTrue(expectedBillingAddressState);
    }
}
