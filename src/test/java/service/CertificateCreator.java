package service;

import model.Certificate;

import static util.Resolver.resolveTemplate;

public class CertificateCreator {
    public static final String RECIPIENT_NAME_TEMPLATE = "test.data.%s.recipient";
    public static final String RECIPIENT_EMAIL_TEMPLATE = "test.data.%s.email";
    public static final String SENDER_NAME_TEMPLATE = "test.data.%s.sender";
    public static final String PRICE_TEMPLATE = "test.data.%s.price";

    public static Certificate withParametersFromProperty(String certificateNumber) {
        certificateNumber = certificateNumber.toLowerCase();

        String recipientName = resolveTemplate(RECIPIENT_NAME_TEMPLATE, certificateNumber);
        System.out.println(recipientName);
        String recipientEmail = resolveTemplate(RECIPIENT_EMAIL_TEMPLATE, certificateNumber);
        String senderName = resolveTemplate(SENDER_NAME_TEMPLATE, certificateNumber);
        String price = resolveTemplate(PRICE_TEMPLATE, certificateNumber);

        return new Certificate(TestDataReader.getTestData(recipientName),
                               TestDataReader.getTestData(recipientEmail),
                               TestDataReader.getTestData(senderName),
                               Integer.parseInt(TestDataReader.getTestData(price)));
    }
}
