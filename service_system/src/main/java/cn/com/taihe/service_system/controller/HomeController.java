package cn.com.taihe.service_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("index")
    public String index(){
        return "service_system home index";
    }
}
