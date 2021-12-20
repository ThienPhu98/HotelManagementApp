package hotelManagement.process.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
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
}
