package prac.pracspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringController {

    @GetMapping("spring")
    public String spring(Model model){
        model.addAttribute("data", "spring");
        model.addAttribute("data2", "jjwon915");
        return "spring";
    }

    @GetMapping("greeting")
    public String greet(@RequestParam(value="name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return "greeting-user";
    }
}
