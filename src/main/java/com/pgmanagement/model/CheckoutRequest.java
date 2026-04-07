package com.pgmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "checkout_requests")
public class CheckoutRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tenant_id")
    private int tenantId;

    @Column(name = "request_type")
    private String requestType;

    @Column(name = "requested_date")
    private String requestedDate;

    @Column(name = "requested_time")
    private String requestedTime;

    private String reason;
    private String status;

    @Column(name = "created_at")
    private String createdAt;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTenantId() { return tenantId; }
    public void setTenantId(int tenantId) { this.tenantId = tenantId; }

    public String getRequestType() { return requestType; }
    public void setRequestType(String requestType) { this.requestType = requestType; }

    public String getRequestedDate() { return requestedDate; }
    public void setRequestedDate(String requestedDate) { this.requestedDate = requestedDate; }

    public String getRequestedTime() { return requestedTime; }
    public void setRequestedTime(String requestedTime) { this.requestedTime = requestedTime; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}