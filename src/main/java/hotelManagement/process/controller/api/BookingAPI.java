package hotelManagement.process.controller.api;

import hotelManagement.process.model.Reservation;
import hotelManagement.process.service.reservation.IReservationService;
import hotelManagement.process.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingAPI {

    @Autowired
    public IReservationService reservationService;

    @Autowired
    private AppUtils appUtils;

    @PostMapping("/create")
    public ResponseEntity<?> createReservation(@Validated  @RequestBody Reservation reservation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }
        reservation = reservationService.save(reservation);
        return new ResponseEntity<>( reservation, HttpStatus.CREATED);
    }


}
