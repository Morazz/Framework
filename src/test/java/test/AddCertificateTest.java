package test;

import model.Certificate;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CertificatePage;
import service.CertificateCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AddCertificateTest extends CommonConditions{

    @Test
    public void addCertificate() {
        Certificate testCertificate = CertificateCreator.withParametersFromProperty("first");
        Certificate expectedCertificate = new CertificatePage(driver)
                .openPage()
                .addCertificate(testCertificate);
        assertThat(expectedCertificate, is(equalTo(testCertificate)));
    }
}
