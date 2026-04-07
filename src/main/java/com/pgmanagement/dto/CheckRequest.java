package com.pgmanagement.dto;

public class CheckRequest {

    private int userId;
    private int roomId;
    private String requestType;
    private String requestDate;
    private String requestTime;
    private String reason;

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public String getRequestType() { return requestType; }
    public void setRequestType(String requestType) { this.requestType = requestType; }

    public String getRequestDate() { return requestDate; }
    public void setRequestDate(String requestDate) { this.requestDate = requestDate; }

    public String getRequestTime() { return requestTime; }
    public void setRequestTime(String requestTime) { this.requestTime = requestTime; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}