package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HomeController {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }
    @RequestMapping("/user/{id}")
    @ResponseBody
    public /*String*/ Object user(
            @PathVariable Long id,
            @RequestParam(name = "test3", required = false, defaultValue="Mikolaj") String name,
            @RequestParam(required = false, defaultValue = "5") Integer age
    ) {
        UserEntity userEntity = new UserEntity(id, name, age);
        return userEntity;
//        return id + " <--- " + name + " "+ age;
    }
    // http://localhost:8080/test?wariant=1
    @RequestMapping("/test")
    public String test(
            @RequestParam Integer wariant
    ) {
        if (wariant == 1) {
            return "test"; // test.html w templates
        } else {
            return "test2"; // test2.html w templates
        }
    }
}