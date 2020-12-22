package test;

import model.Card;
import org.testng.annotations.Test;
import page.ProductPage;
import service.CardCreator;
import service.TestDataReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckoutTest extends CommonConditions{
    private String cardNumber = "first";


    @Test
    public void enterInvalidCouponCodeTest() {
        String expectedMessage = new ProductPage(driver)
                .openPage()
                .addProducts(TestDataReader.getTestData("test.data.count"))
                .goToCart()
                .goToCheckoutPage()
                .enterCouponCode(TestDataReader.getTestData("test.data.promocode"));
        assertThat(expectedMessage, is(equalTo(TestDataReader.getTestData("test.data.coupon.error"))));
    }

    @Test
    public void enterInvalidCardTest() {
        Card testCard = CardCreator.withCredentialsFromProperties(cardNumber);
        Card expectedCard = new ProductPage(driver)
                .openPage()
                .addProducts(TestDataReader.getTestData("test.data.count"))
                .goToCart()
                .goToCheckoutPage()

    }
}
