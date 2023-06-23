package com.exam.ekaterine_gurgenidze.repositories;

import com.exam.ekaterine_gurgenidze.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
//    List<Room> findByIsEmptyTrue();

 //   List<Room> findByIsEmptyFalse();

    @Query("SELECT r FROM Room r WHERE NOT EXISTS " +
            "(SELECT res FROM Reservation res WHERE res.room.id = r.id AND " +
            "CURRENT_TIMESTAMP() BETWEEN res.checkInTime AND res.checkOutTime)")
    List<Room> findFreeRooms();


    @Query(value = "SELECT * FROM room r " +
            "WHERE r.id NOT IN (" +
            "  SELECT res.room_id FROM reservation res " +
            "  WHERE CURRENT_TIMESTAMP() BETWEEN res.check_in_time AND res.check_out_time" +
            ")",
            nativeQuery = true)
    List<Room> freeRooms();

    @Query("SELECT r FROM Room r WHERE EXISTS " +
            "(SELECT res FROM Reservation res WHERE res.room.Id = r.Id AND " +
            "CURRENT_TIMESTAMP() BETWEEN res.checkInTime AND res.checkOutTime)")
    List<Room> findNotFreeRooms();



    @Query(value = "SELECT * FROM room r " +
            "WHERE r.id  IN (" +
            "  SELECT res.room_id FROM reservation res " +
            "  WHERE CURRENT_TIMESTAMP() BETWEEN res.check_in_time AND res.check_out_time" +
            ")",
            nativeQuery = true)
    List<Room> notFreeRooms();


    /*
     @Query("SELECT r FROM Room r WHERE EXISTS " +
            "(SELECT res FROM Reservation res WHERE res.room.Id = r.Id AND " +
            "CURRENT_TIMESTAMP(6) BETWEEN res.checkInTime AND res.checkOutTime)")

    * */


    /*
    SELECT * FROM Room r WHERE EXISTS (SELECT * FROM Reservation res WHERE res.room_id = r.Id
    AND CURRENT_TIMESTAMP(6) BETWEEN res.check_in_time AND res.check_out_time);
     */


    //    @Query(value = "select * from reservation res " +
//            "inner join room" +
//            "ON res.room_id = room.id AND CURRENT_TIMESTAMP() BETWEEN res.check_in_time AND res.check_out_time",
//            nativeQuery = true)
}
