package page;

import model.Certificate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.abstractPages.AbstractPage;
import service.TestDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static util.Resolver.resolvePrice;

public class CertificatePage extends AbstractPage {
    private final String CERTIFICATEPAGE_URL = "https://demeterfragrance.com/gift-certificate.html";
    private Certificate certificate;
    private Logger log = LogManager.getRootLogger();

    @FindBy(id="recipient_name")
    private WebElement recipient;

    @FindBy(id = "recipient_email")
    private WebElement email;

    @FindBy(id = "sender_name")
    private WebElement sender;

    @FindBy(id = "price_10")
    private WebElement price;

    @FindBy(className = "addtocart")
    private WebElement addButton;

    public CertificatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Certificate addCertificate() {
        recipient.click();
        recipient.sendKeys(TestDataReader.getTestData("test.data.first.recipient"));
        email.click();
        email.sendKeys(TestDataReader.getTestData("test.data.first.email"));
        sender.click();
        sender.sendKeys(TestDataReader.getTestData("test.data.first.sender"));
        price.click();
        certificate = new Certificate(recipient.getText(), email.getText(), sender.getText(), resolvePrice(price.getAttribute("value")));
        addButton.click();
        return certificate;
    }

    @Override
    public CertificatePage openPage() {
        driver.navigate().to(CERTIFICATEPAGE_URL);
        return this;
    }
}
