package cn.com.taihe.service_order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "system",fallback = SystemFeignClientFallback.class)
public interface SystemFeignClient {

    @RequestMapping("/home/index")
    public String systemHomeIndex();
}
