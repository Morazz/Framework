package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.abstractpages.AbstractPage;

public class StoresPage extends AbstractPage {
    private final String STORES_URL = "https://demeterfragrance.com/stores/";
    private final int timeWait = 10;

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
        new WebDriverWait(driver, timeWait)
                .until(ExpectedConditions.visibilityOf(storesList));
        return storesList.isDisplayed();
    }

    @Override
    public StoresPage openPage() {
        driver.navigate().to(STORES_URL);
        return this;
    }
}
