package com.pgmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "room_id")
    private int roomId;

    @Column(name = "checkin_date")
    private String checkinDate;

    @Column(name = "checkin_time")
    private String checkinTime;

    @Column(name = "checkout_date")
    private String checkoutDate;

    @Column(name = "checkout_time")
    private String checkoutTime;

    private String status;

    @Column(name = "food_enabled")
    private boolean foodEnabled;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public String getCheckinDate() { return checkinDate; }
    public void setCheckinDate(String checkinDate) { this.checkinDate = checkinDate; }

    public String getCheckinTime() { return checkinTime; }
    public void setCheckinTime(String checkinTime) { this.checkinTime = checkinTime; }

    public String getCheckoutDate() { return checkoutDate; }
    public void setCheckoutDate(String checkoutDate) { this.checkoutDate = checkoutDate; }

    public String getCheckoutTime() { return checkoutTime; }
    public void setCheckoutTime(String checkoutTime) { this.checkoutTime = checkoutTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean isFoodEnabled() { return foodEnabled; }
    public void setFoodEnabled(boolean foodEnabled) { this.foodEnabled = foodEnabled; }
}