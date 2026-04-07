package com.pgmanagement.dto;

public class TenantDetailsDto {

    private int tenantId;
    private String name;
    private String email;
    private String phone;
    private String roomNumber;
    private String roomType;
    private double rent;
    private boolean isAc;
    private String checkinDate;
    private String status;

    public int getTenantId() { return tenantId; }
    public void setTenantId(int tenantId) { this.tenantId = tenantId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public double getRent() { return rent; }
    public void setRent(double rent) { this.rent = rent; }

    public boolean isAc() { return isAc; }
    public void setAc(boolean ac) { isAc = ac; }

    public String getCheckinDate() { return checkinDate; }
    public void setCheckinDate(String checkinDate) { this.checkinDate = checkinDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}