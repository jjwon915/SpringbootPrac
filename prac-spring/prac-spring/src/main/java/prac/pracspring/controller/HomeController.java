package prac.pracspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import prac.pracspring.domain.Member;
import prac.pracspring.service.MemberService;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
