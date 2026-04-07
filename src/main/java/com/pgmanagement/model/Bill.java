package com.pgmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tenant_id")
    private int tenantId;

    private String month;
    private int year;

    @Column(name = "rent_amount")
    private double rentAmount;

    @Column(name = "food_amount")
    private double foodAmount;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "paid_amount")
    private double paidAmount;

    private String status;

    @Column(name = "generated_at")
    private String generatedAt;

    @Column(name = "paid_at")
    private String paidAt;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTenantId() { return tenantId; }
    public void setTenantId(int tenantId) { this.tenantId = tenantId; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getRentAmount() { return rentAmount; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }

    public double getFoodAmount() { return foodAmount; }
    public void setFoodAmount(double foodAmount) { this.foodAmount = foodAmount; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getPaidAmount() { return paidAmount; }
    public void setPaidAmount(double paidAmount) { this.paidAmount = paidAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(String generatedAt) { this.generatedAt = generatedAt; }

    public String getPaidAt() { return paidAt; }
    public void setPaidAt(String paidAt) { this.paidAt = paidAt; }

    public double getBalance() {
        return totalAmount - paidAmount;
    }
}