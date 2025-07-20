package com.zidio.zidioconnect.dto;

public class RazorpayOrderRequest {

    private int amount;
    private String currency;
    private String receipt;

    public RazorpayOrderRequest() {
        // Default constructor
    }

    public RazorpayOrderRequest(int amount, String currency, String receipt) {
        this.amount = amount;
        this.currency = currency;
        this.receipt = receipt;
    }

    // Getters and setters
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }
}
