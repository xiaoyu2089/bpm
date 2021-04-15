package cn.com.taihe.service_order.feign;

import org.springframework.stereotype.Component;

@Component
public class SystemFeignClientFallback implements SystemFeignClient{

    @Override
    public String systemHomeIndex(){
        return "服务暂时无法调用";
    }
}
