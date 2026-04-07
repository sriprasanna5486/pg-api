package com.pgmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "room_type")
    private String roomType;

    private int capacity;
    private int occupied;
    private double rent;

    @Column(name = "is_ac")
    private boolean isAc;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getOccupied() { return occupied; }
    public void setOccupied(int occupied) { this.occupied = occupied; }

    public double getRent() { return rent; }
    public void setRent(double rent) { this.rent = rent; }

    public boolean isAc() { return isAc; }
    public void setAc(boolean ac) { isAc = ac; }

    public boolean isAvailable() {
        return occupied < capacity;
    }
}