package uz.bakhromjon.controller.auth;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.bakhromjon.controller.BaseAbstractController;
import uz.bakhromjon.dto.user.UserCreateDto;
import uz.bakhromjon.service.auth.AuthUserService;

import java.security.Principal;

/**
 * @author Bakhromjon Fri, 9:47 PM 2/18/2022
 */
@Controller
@RequestMapping("/auth/*")
public class AuthController extends BaseAbstractController<AuthUserService> {

    public AuthController(AuthUserService service) {
        super(service);
    }

    @GetMapping("login/")
    public String loginPage() {
        return "/auth/login";
    }


    @GetMapping("logout/")
    public String logoutPage() {
        return "/auth/logout";
    }

    @GetMapping("register/")
    public String registrationPage() {
        return "auth/register";
    }


    @PostMapping("register/")
    public String registration(@ModelAttribute UserCreateDto userCreateDto) {
        service.registration(userCreateDto);
        return "redirect:/home";
    }


    // TODO: 2/20/2022 add verify
//    @GetMapping("verify_code/")
//    public String verifyPage() {
//        return "/auth/verify";
//    }
//
//
//    @PostMapping("verify_code/")
//    public String verify(Long otp, Model model) {
//        boolean verified = service.verify(otp);
//        if (!verified) {
//            model.addAttribute("message", "Wrong OTP code");
//            return "/auth/verify";
//        }
//        return "/home";
//    }
}
