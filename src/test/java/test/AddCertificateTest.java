package test;

import model.Certificate;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CertificatePage;
import service.CertificateCreator;

import static org.assertj.core.api.Assertions.assertThat;

public class AddCertificateTest extends CommonConditions{

    @Test
    public void addCertificate() {
        String certificateNumber = "first";
        Certificate testCertificate = CertificateCreator.withParametersFromProperty(certificateNumber);
        Certificate expectedCertificate = new CertificatePage(driver)
                .openPage()
                .addCertificate(testCertificate);
        assertThat(expectedCertificate).isEqualTo(testCertificate);
    }
}
