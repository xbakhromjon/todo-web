package uz.bakhromjon.controller.auth;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.bakhromjon.dto.user.UserDto;

/**
 * @author Bakhromjon Fri, 9:47 PM 2/18/2022
 */
@Controller
@RequestMapping("/auth/*")
public class AuthController {

    @GetMapping("login/")
    public String loginPage() {
        return "/auth/login";
    }


    @GetMapping("logout/")
    public String logoutPage() {
        return "/auth/logout";
    }

    @GetMapping("registration/")
    public String registrationPage(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());
        return "/auth/registration";
    }
}
