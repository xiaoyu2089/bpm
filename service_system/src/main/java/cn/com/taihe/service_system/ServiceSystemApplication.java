package cn.com.taihe.service_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSystemApplication.class, args);
    }

}
