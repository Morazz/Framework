package test;

import org.testng.annotations.Test;
import page.ProductPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckoutTest extends CommonConditions{

    @Test
    public void enterInvalidCouponCodeTest() {
        String expectedMessage = new ProductPage(driver)
                .openPage()
                .addProducts("100")
                .goToCart()
                .goToCheckoutPage()
                .enterCouponCode();
        assertThat(expectedMessage, is(equalTo("The coupon code you entered could not be found.")));
    }
}
