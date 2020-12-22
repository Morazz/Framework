package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.StoresPage;
import static org.hamcrest.MatcherAssert.*;

public class StoresSearchTest extends CommonConditions {
    private final String zip = "91204";

    @Test
    public void searchStoresTest() {
        boolean expectedStoresState = new StoresPage(driver)
            .openPage()
            .findStore(zip);
        Assert.assertTrue(expectedStoresState);
    }
}
