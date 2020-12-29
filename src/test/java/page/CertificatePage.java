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
import static util.Resolver.resolveTemplate;

public class CertificatePage extends AbstractPage {
    private final String CERTIFICATEPAGE_URL = "https://demeterfragrance.com/gift-certificate.html";
    public static final String RECIPIENT_NAME_TEMPLATE = "test.data.%s.recipient";
    public static final String RECIPIENT_EMAIL_TEMPLATE = "test.data.%s.email";
    public static final String SENDER_NAME_TEMPLATE = "test.data.%s.sender";
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

    public Certificate addCertificate(String template) {
        recipient.click();
        recipient.sendKeys(TestDataReader.getTestData(resolveTemplate(RECIPIENT_NAME_TEMPLATE, template)));
        email.click();
        email.sendKeys(TestDataReader.getTestData(resolveTemplate(RECIPIENT_EMAIL_TEMPLATE, template)));
        sender.click();
        sender.sendKeys(TestDataReader.getTestData(resolveTemplate(SENDER_NAME_TEMPLATE, template)));
        price.click();
        certificate = new Certificate(recipient.getAttribute("value"),
                                      email.getAttribute("value"),
                                      sender.getAttribute("value"),
                                      resolvePrice(price.getAttribute("value")));
        addButton.click();
        return certificate;
    }

    @Override
    public CertificatePage openPage() {
        driver.navigate().to(CERTIFICATEPAGE_URL);
        return this;
    }
}
