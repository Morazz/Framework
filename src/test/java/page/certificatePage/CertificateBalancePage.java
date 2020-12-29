package page.certificatePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import page.AbstractPage;
import service.TestDataReader;

public class CertificateBalancePage extends AbstractPage {
    private final String BALANCEPAGE_URL = "https://demeterfragrance.com/check-gift-card-balance.html";
    private final Logger logger = LogManager.getRootLogger();


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
        logger.info("Check if certificate balance is displayed");
        certificateInput.click();
        certificateInput.sendKeys(TestDataReader.getTestData("test.data.promocode"));
        getBalanceButton.click();
        return certificateBalance.isDisplayed();
    }

    public CertificateBalancePage openPage() {
        driver.navigate().to(BALANCEPAGE_URL);
        return this;
    }
}
