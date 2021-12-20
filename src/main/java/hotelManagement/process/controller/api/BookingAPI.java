package hotelManagement.process.controller.api;

import hotelManagement.process.model.Reservation;
import hotelManagement.process.service.reservation.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingAPI {

    @Autowired
    public IReservationService reservationService;

    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        reservation = reservationService.save(reservation);
        return new ResponseEntity<>( reservation, HttpStatus.CREATED);
    }
}
