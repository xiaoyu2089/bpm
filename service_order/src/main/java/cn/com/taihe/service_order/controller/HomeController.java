package cn.com.taihe.service_order.controller;

import cn.com.taihe.service_order.feign.SystemFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("home")
public class HomeController {

    @Resource
    private SystemFeignClient systemFeignClient;

    @RequestMapping("/index")
    public String index(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "service_order home index|"+systemFeignClient.systemHomeIndex();
    }
}
