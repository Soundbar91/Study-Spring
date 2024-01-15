package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // http://localhost:8080/에 접속하면 처음 실행
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
