package uz.bakhromjon.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.bakhromjon.controller.BaseAbstractController;
import uz.bakhromjon.dto.user.UserDto;
import uz.bakhromjon.dto.user.UserUpdateDto;
import uz.bakhromjon.service.user.UserService;

/**
 * @author Bakhromjon Fri, 9:47 PM 2/18/2022
 */
@Controller
@RequestMapping("/user/*")
public class UserController extends BaseAbstractController<UserService> {
    public UserController(UserService service) {
        super(service);
    }

    @GetMapping("update/")
    public String updatePage() {
        return "/user/update";
    }


    @PostMapping("update/")
    public String update(@ModelAttribute UserUpdateDto userUpdateDto) {
        service.update(userUpdateDto);
        return "/home";
    }

    @GetMapping("user_info/{id}")
    public ModelAndView get(@PathVariable Long id, ModelAndView modelAndView) {
        UserDto userDto = service.get(id);
        modelAndView.addObject("user", userDto);
        modelAndView.setViewName("/user/user_info");
        return modelAndView;
    }

}
