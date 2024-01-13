package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    // 정적 컨텐츠
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    /*
        MVC & 템플릿 엔진
        @RequestParam : 파라미터 입력 받기, model (키 : name, 값 : 파라미터)
        viewResolver으로 던짐
     */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API
    @GetMapping("hello-string")
    @ResponseBody // http 바디 부분에 내용을 직접 넣겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;  // 글자 그대로 내린다. html 코드 x
    }

    /*
        json (키, 값) - 기본 방식으로 반환
        @ResponseBody - HttpMessageConverter 동작
        객체인 경우 MappingJackson2HttpMessageConverter 작동
        문자열인 경우 StringHttpMessageConverter 작동
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
