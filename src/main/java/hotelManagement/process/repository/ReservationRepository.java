package hotelManagement.process.repository;

import hotelManagement.process.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT NEW  hotelManagement.process.model.ReservationDTO (c.bookingCode, c.fullName, c.email, c.phone, c.address, c.guaranteeFee, c.methodPayment, c.room) " +
            "FROM Reservation c WHERE c.deleted = false AND c.checkedIn = false")
    Iterable<Reservation> findAllReservation();

    @Query("SELECT NEW hotelManagement.process.model.ReservationDTO  (c.bookingCode, c.fullName, c.email, c.phone, c.address, c.guaranteeFee, c.methodPayment, c.room) " +
            "FROM Reservation c WHERE c.deleted = false AND c.checkedIn = true")
    Iterable<Reservation> findAllInHouseGuestList();

    @Query("SELECT NEW hotelManagement.process.model.ReservationDTO  (c.bookingCode, c.fullName, c.email, c.phone, c.address, c.guaranteeFee, c.methodPayment, c.room) " +
            "FROM Reservation c WHERE c.bookingCode = ?1 AND c.phone = ?2")
    Reservation findReservationByBookingCode(Long bookingCode, String phone);


}
