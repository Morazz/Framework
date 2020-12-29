package test;

import org.testng.annotations.Test;
import page.storesPage.StoresPage;
import service.TestDataReader;

import static org.assertj.core.api.Assertions.assertThat;

public class StoresSearchTest extends CommonConditions {

    @Test
    public void searchStoresTest() {
        boolean expectedStoresState = new StoresPage(driver)
            .openPage()
            .findStore(TestDataReader.getTestData("test.data.zip"));
        assertThat(expectedStoresState).isTrue();
    }
}
