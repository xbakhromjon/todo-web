package uz.bakhromjon.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Bakhromjon Fri, 9:46 PM 2/18/2022
 */
@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String home() {
        return "/home";
    }
}
