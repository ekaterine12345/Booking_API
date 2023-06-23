package com.exam.ekaterine_gurgenidze.repositories;

import com.exam.ekaterine_gurgenidze.entities.Hotel;
import com.exam.ekaterine_gurgenidze.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("SELECT r FROM Room r WHERE r.hotel.id = :hotelId AND NOT EXISTS " +
            "(SELECT res FROM Reservation res WHERE res.room.Id = r.Id AND " +
            "CURRENT_TIMESTAMP() BETWEEN res.checkInTime AND res.checkOutTime)")
    List<Room> findFreeRoomsByHotelId(@Param("hotelId") Long hotelId);

//          nativeQuery-თი დაწერილი

//    @Query(value = "SELECT * FROM room r " +
//            "WHERE r.hotel_id = :hotelId AND NOT EXISTS (" +
//            "  SELECT 1 FROM reservation res " +
//            "  WHERE res.room_id = r.id " +
//            "  AND (CURRENT_TIMESTAMP() BETWEEN res.check_in_time AND res.check_out_time)" +
//            ")",
//            nativeQuery = true)
//    List<Room> findFreeRoomsByHotelId(@Param("hotelId") Long hotelId);

    @Query("SELECT hotel.name as HotelName, YEAR(reservation.checkInTime) AS rentalYear," +
            " COUNT(room) AS RentRoom," +
            " COUNT(distinct room) as NumberofRooms," +
            " SUM(room.price * DATEDIFF(reservation.checkOutTime, reservation.checkInTime)) AS Money," +
            "  SUM (DATEDIFF(reservation.checkOutTime, reservation.checkInTime)) AS duration " +
            "FROM Reservation reservation " +
            "JOIN reservation.room room " +
            "JOIN room.hotel hotel " +
            "WHERE hotel.id = :hotelId " +
            "GROUP BY rentalYear")
    List<Object> getHotelReport(@Param("hotelId") Long hotelId);


    //          nativeQuery-თი დაწერილი
    @Query(value = "SELECT hotel.name AS HotelName, YEAR(reservation.check_in_time) AS rentalYear," +
            " COUNT(room.id) AS RentRoom," +
            " COUNT(DISTINCT room.id) AS NumberofRooms," +
            " SUM(room.price * DATEDIFF(reservation.check_out_time, reservation.check_in_time)) AS Money," +
            " SUM(DATEDIFF(reservation.check_out_time, reservation.check_in_time)) AS duration " +
            "FROM reservation " +
            "JOIN room ON reservation.room_id = room.id " +
            "JOIN hotel ON room.hotel_id = hotel.id " +
            "WHERE hotel.id = :hotelId " +
            "GROUP BY rentalYear",
            nativeQuery = true)
    List<Object> getHotelReport1(@Param("hotelId") Long hotelId);


}
