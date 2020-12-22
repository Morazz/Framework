package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
    public final String HOMEPAGE_URL = "https://demeterfragrance.com/";
    private final int timeWait = 10;

    @FindBy(xpath = "/html/body/div[1]/header/div[4]/div[1]")
    private WebElement searchScope;

    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(className = "item")
    private WebElement stores;


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        return  this;
    }
}
