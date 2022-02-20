package uz.bakhromjon.controller.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.bakhromjon.controller.BaseAbstractController;
import uz.bakhromjon.dto.task.TaskCreateDto;
import uz.bakhromjon.dto.task.TaskDto;
import uz.bakhromjon.dto.task.TaskUpdateDto;
import uz.bakhromjon.service.task.TaskService;

/**
 * @author Bakhromjon Fri, 9:48 PM 2/18/2022
 */
@Controller
@RequestMapping("/task/*")
public class TaskController extends BaseAbstractController<TaskService> {

    public TaskController(TaskService service) {
        super(service);
    }

    @GetMapping("create")
    public String createPage() {
        return "/task/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute TaskCreateDto taskCreateDto) {
        Long id = service.create(taskCreateDto);
        return "/profile";
    }


    @GetMapping("delete/{id}")
    public String deletePage(@PathVariable Long id, Model model) {
        service.get(id);
        model.addAttribute("id", id);
        return "/task/delete";
    }


    @PostMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/user/profile/";
    }

    @GetMapping("update/{id}")
    public String updatePage(@PathVariable Long id, Model model) {
        TaskDto taskDto = service.get(id);
        model.addAttribute("task", taskDto);
        return "/task/update";
    }


    @PostMapping("update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute TaskUpdateDto taskUpdateDto) {
        service.update(taskUpdateDto);
        return "redirect:/user/profile/";
    }

    @GetMapping("task_info/{id}")
    public String taskPage(@PathVariable Long id, Model model) {
        TaskDto taskDto = service.get(id);
        model.addAttribute("task", taskDto);
        return "/task/task_info";
    }

}
