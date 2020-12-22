package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CertificateBalancePage extends AbstractPage {
    private final String BALANCEPAGE_URL = "https://demeterfragrance.com/check-gift-card-balance.html";
    private final String certificate = "123123";

    @FindBy(id = "c_code")
    private WebElement certificateInput;

    @FindBy(id = "get_balance")
    private WebElement getBalanceButton;

    @FindBy(id = "cert_balance")
    private  WebElement certificateBalance;

    public CertificateBalancePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean getCertificateBalance() {
        certificateInput.click();
        certificateInput.sendKeys(certificate);
        getBalanceButton.click();
        return certificateBalance.isDisplayed();
    }

    @Override
    public CertificateBalancePage openPage() {
        driver.navigate().to(BALANCEPAGE_URL);
        return this;
    }
}
