package hotelManagement.process.service.reservation;

import hotelManagement.process.model.Reservation;
import hotelManagement.process.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements  IReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void remove(Long id) {

    }
}
