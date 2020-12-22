package model;

import java.util.Objects;

public class Certificate {
    private String recipientName;
    private String recipientEmail;
    private String senderName;
    private int price;

    public Certificate(String recipientName, String recipientEmail, String senderName, int price) {
        this.recipientName = recipientName;
        this.recipientEmail = recipientEmail;
        this.senderName = senderName;
        this.price = price;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "recipientName='" + recipientName + '\'' +
                ", recipientEmail='" + recipientEmail + '\'' +
                ", senderName='" + senderName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Certificate)) return false;
        Certificate certificate = (Certificate) o;
        return Objects.equals(getRecipientName(), certificate.getRecipientName()) &&
                Objects.equals(getRecipientEmail(), certificate.getRecipientEmail()) &&
                Objects.equals(getSenderName(), certificate.getSenderName()) &&
                Objects.equals(getPrice(), certificate.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipientName(), getRecipientEmail(), getSenderName(), getPrice());
    }
}
