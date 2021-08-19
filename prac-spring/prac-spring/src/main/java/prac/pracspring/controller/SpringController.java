package prac.pracspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("string-test")
    @ResponseBody
    public String stringTest(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-info")
    @ResponseBody
    public Info helloInfo(@RequestParam("name") String name, @RequestParam("age") int age){
        Info info = new Info();
        info.setName(name);
        info.setAge(age);
        return info;
    }

    static class Info{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
