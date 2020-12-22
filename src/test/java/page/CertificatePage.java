package page;

import model.Certificate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.abstractPages.AbstractPage;

import static util.Resolver.resolvePrice;

public class CertificatePage extends AbstractPage {
    private final String CERTIFICATEPAGE_URL = "https://demeterfragrance.com/gift-certificate.html";
    private Certificate certificate;

    @FindBy(id = "recipient_name")
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

    public Certificate addCertificate(Certificate certificate) {
        recipient.click();
        recipient.sendKeys(certificate.getRecipientName());
        email.click();
        email.sendKeys(certificate.getRecipientEmail());
        sender.click();
        sender.sendKeys(certificate.getSenderName());
        price.click();
        addButton.click();
        return new Certificate(recipient.getText(), email.getText(), sender.getText(), resolvePrice(price.getText()));
    }

    @Override
    public CertificatePage openPage() {
        driver.navigate().to(CERTIFICATEPAGE_URL);
        return this;
    }
}
