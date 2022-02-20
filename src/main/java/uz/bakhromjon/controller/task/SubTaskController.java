package uz.bakhromjon.controller.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.bakhromjon.controller.BaseAbstractController;
import uz.bakhromjon.dto.task.*;
import uz.bakhromjon.service.task.SubTaskService;

/**
 * @author Bakhromjon Fri, 9:48 PM 2/18/2022
 */
@Controller
@RequestMapping("/subtask/*")
public class SubTaskController extends BaseAbstractController<SubTaskService> {
    public SubTaskController(SubTaskService service) {
        super(service);
    }

    @GetMapping("create/")
    public String createPage() {
        return "/task/create";
    }

    @PostMapping("create/")
    public String create(@ModelAttribute SubTaskCreateDto subTaskCreateDto) {
        Long id = service.create(subTaskCreateDto);
        return "redirect:/user/profile";
    }


    @GetMapping("delete/{id}/")
    public String deletePage(@PathVariable Long id, Model model) {
        service.get(id);
        return "/task/delete";
    }


    @PostMapping("delete/{id}/")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/user/profile/";
    }

    @GetMapping("update/{id}/")
    public String updatePage(@PathVariable Long id, Model model) {
        SubTaskDto subTaskDto = service.get(id);
        model.addAttribute("task", subTaskDto);
        return "/task/update";
    }


    @PostMapping("update/{id}/")
    public String update(@PathVariable Long id, @ModelAttribute SubTaskUpdateDto subTaskUpdateDto) {
        service.update(subTaskUpdateDto);
        return "redirect:/user/profile/";
    }

    @GetMapping("task_info/{id}/")
    public String taskPage(@PathVariable Long id, Model model) {
        SubTaskDto subTaskDto = service.get(id);
        model.addAttribute("task", subTaskDto);
        return "/task/task_info";
    }
}
