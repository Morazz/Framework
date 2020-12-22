package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{
    private final String LOGINPAGE_URL = "https://demeterfragrance.com/customer-login.html";

    @FindBy(id = "u_name")
    private WebElement emailInput;

    @FindBy(id = "u_pass")
    private WebElement passwordInput;

    @FindBy(name = "submit")
    private WebElement loginButton;

    public  LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(LOGINPAGE_URL);
        return this;
    }
}
