package test;

import model.Card;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.CheckoutPage;
import page.ProductPage;
import service.CardCreator;
import service.TestDataReader;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(expectedMessage).isEqualTo(TestDataReader.getTestData("test.data.coupon.error"));
    }

    @Test
    public void enterInvalidCardTest() {
        CheckoutPage checkoutPage = new ProductPage(driver)
                .openPage()
                .addProducts(TestDataReader.getTestData("test.data.count"))
                .goToCart()
                .goToCheckoutPage();
        String warning = checkoutPage.enterCard();

        assertThat(warning).isEqualTo(TestDataReader.getTestData("test.data.card.number.error"));
    }
}
