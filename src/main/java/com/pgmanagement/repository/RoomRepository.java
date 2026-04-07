package com.pgmanagement.repository;

import com.pgmanagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RoomRepository
        extends JpaRepository<Room, Integer> {

    // Get all available rooms
    // (occupied less than capacity)
    @Query("SELECT r FROM Room r " +
           "WHERE r.occupied < r.capacity")
    List<Room> findAvailableRooms();
}