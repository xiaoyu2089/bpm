package cn.com.taihe.application_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ApplicationZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationZuulApplication.class, args);
    }

}
