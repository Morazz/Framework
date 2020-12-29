package test;

import org.testng.annotations.Test;
import page.certificatePage.CertificateBalancePage;

import static org.assertj.core.api.Assertions.assertThat;

public class CertificateBalanceTest extends CommonConditions {

    @Test
    public void checkThatCertificateCreated() {
        boolean expectedCertificatePageCondition = new CertificateBalancePage(driver)
                .openPage()
                .getCertificateBalance();
        assertThat(expectedCertificatePageCondition).isTrue();
    }
}
