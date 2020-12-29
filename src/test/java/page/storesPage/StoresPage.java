package page.storesPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractPage;

public class StoresPage extends AbstractPage {
    private final String STORES_URL = "https://demeterfragrance.com/stores/";

    @FindBy(id = "address")
    private WebElement zipInput;

    @FindBy(className = "get_btn")
    private WebElement findButton;

    @FindBy(className = "group")
    private WebElement storesList;

    public StoresPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean findStore(String zip) {
        zipInput.click();
        zipInput.sendKeys(zip);
        findButton.click();
        waitElementVisibility(storesList);
        return storesList.isDisplayed();
    }

    public StoresPage openPage() {
        driver.navigate().to(STORES_URL);
        return this;
    }
}
