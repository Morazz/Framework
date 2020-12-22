package service;

import model.Card;

import static util.Resolver.resolveTemplate;

public class CardCreator {
    public static final String CARD_TEMPLATE = "test.data.year";
    public static final String YEAR_TEMPLATE = "test.data.year";
    public static final String MONTH_TEMPLATE = "test.data.month";
    public static final String CSC_TEMPLATE = "test.data.CSC";

    public static Card withCredentialsFromProperties(String cardNumber) {
        cardNumber = cardNumber.toLowerCase();

        String card = resolveTemplate(CARD_TEMPLATE, cardNumber);
        String year = resolveTemplate(YEAR_TEMPLATE, cardNumber);
        String month = resolveTemplate(MONTH_TEMPLATE, cardNumber);
        String CSC = resolveTemplate(CSC_TEMPLATE, cardNumber);

        return new Card(Integer.parseInt(TestDataReader.getTestData(card)),
                        Integer.parseInt(TestDataReader.getTestData(month)),
                        Integer.parseInt(TestDataReader.getTestData(year)),
                        Integer.parseInt(TestDataReader.getTestData(CSC)));
    }
}
