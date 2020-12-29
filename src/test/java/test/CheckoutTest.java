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

    @Test
    public void enterInvalidCouponCodeTest() {
        CheckoutPage checkoutPage = new ProductPage(driver)
                .openPage()
                .addProducts(TestDataReader.getTestData("test.data.count"))
                .goToCart()
                .goToCheckoutPage();

        double priceBefore = checkoutPage.getTotalPrice();
        String expectedMessage = checkoutPage
                .enterCouponCode(TestDataReader.getTestData("test.data.promocode"));
        double priceAfter = checkoutPage.getTotalPrice();

        assertThat(expectedMessage).isEqualTo(TestDataReader.getTestData("test.data.coupon.error"));
        assertThat(priceBefore).isEqualTo(priceAfter);
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
