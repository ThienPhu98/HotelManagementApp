package hotelManagement.process.controller;

import hotelManagement.process.model.Reservation;
import hotelManagement.process.model.Room;
import hotelManagement.process.service.reservation.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private IReservationService reservationService;

    @GetMapping("/")
    public String showIndex() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/home");
        return modelAndView;
    }

    @GetMapping("/booking")
    public ModelAndView showBookingPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/booking");
        return modelAndView;
    }

    @GetMapping("/findBooking")
    public ModelAndView showFindBookingForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/findBooking");
        return modelAndView;
    }

    @PostMapping("/findBooking")
    public ModelAndView findBooking(@ModelAttribute("bookingCode") long bookingCode) {
        ModelAndView modelAndView = new ModelAndView("/findBooking");
        Optional<Reservation> reservationOptional = reservationService.findById(bookingCode);
        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();
            Room room = reservation.getRoom();
            modelAndView.addObject("reservation", reservation);
            modelAndView.addObject("room", room);
        } else {
            modelAndView.addObject("message", "Can't found reservation by that booking code! please try again.");
        }
        return modelAndView;
    }
}
