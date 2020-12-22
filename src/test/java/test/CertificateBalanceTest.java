package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CertificateBalancePage;

public class CertificateBalanceTest extends CommonConditions {

    @Test
    public void getCertificateState() {
        boolean expectedCertificatePageCondition = new CertificateBalancePage(driver)
                .openPage()
                .getCertificateBalance();
        Assert.assertTrue(expectedCertificatePageCondition);
    }
}
