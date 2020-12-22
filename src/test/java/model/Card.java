package model;

import java.util.Objects;

public class Card {
    private int card;
    private int expirationMonth;
    private int expirationYear;
    private int CSC;

    public Card(int card, int expirationMonth, int expirationYear, int CSC) {
        this.card = card;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.CSC = CSC;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public int getExpirationMonth() {
        return  expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return this.expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public int getCSC() {
        return CSC;
    }

    public void setCSC(int CSC) {
        this.CSC = CSC;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card='" + card + '\'' +
                ", expirationMonth='" + expirationMonth + '\'' +
                ", expirationYear'" + expirationYear + '\'' +
                ", CSC='" + CSC + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(getCard(), card.getCard()) &&
                Objects.equals(getExpirationMonth(), card.getExpirationMonth()) &&
                Objects.equals(getExpirationYear(), card.getExpirationYear()) &&
                Objects.equals(getCSC(), card.getCSC());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCard(), getExpirationMonth(), getExpirationYear(), getCSC());
    }
}
