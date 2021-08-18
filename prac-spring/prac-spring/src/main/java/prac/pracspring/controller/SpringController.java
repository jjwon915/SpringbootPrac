package prac.pracspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringController {

    @GetMapping("spring")
    public String spring(Model model){
        model.addAttribute("data", "spring");
        model.addAttribute("data2", "jjwon915");
        return "spring";
    }
}
