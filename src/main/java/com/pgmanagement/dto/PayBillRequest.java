package com.pgmanagement.dto;

public class PayBillRequest {

    private int billId;
    private int tenantId;
    private double amount;
    private String paymentMethod;

    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }

    public int getTenantId() { return tenantId; }
    public void setTenantId(int tenantId) { this.tenantId = tenantId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}