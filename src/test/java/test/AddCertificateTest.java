package test;

import model.Certificate;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CertificatePage;
import service.CertificateCreator;

import static org.assertj.core.api.Assertions.assertThat;

public class AddCertificateTest extends CommonConditions{

    private String certificateNumber = "first";

    @Test
    public void addCertificate() {
        Certificate testCertificate = CertificateCreator.withParametersFromProperty(certificateNumber);
        Certificate expectedCertificate = new CertificatePage(driver)
                .openPage()
                .addCertificate(testCertificate);
        assertThat(expectedCertificate).isEqualTo(testCertificate);
    }
}
