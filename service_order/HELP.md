#订单服务

OpenFeign超时配置

~~~
feign:
  client:
    config:
      default:
        connect-timeout: 500  #链接最大时间
        read-timeout: 60000 # 链接后等待被调用方最长的返回时间 一分钟
~~~

引入Hystrix
1. POM中增加
~~~
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
~~~
2. 新增继承@FeignClient接口的类，实现方法。这里是服务不可用时的做法
~~~
package cn.com.taihe.service_order.feign;

import org.springframework.stereotype.Component;

@Component
public class SystemFeignClientFallback implements SystemFeignClient{

    @Override
    public String systemHomeIndex(){
        return "服务暂时无法调用";
    }
}
~~~
3. 在@FeignClient中增加fallback参数
~~~
package cn.com.taihe.service_order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "system",fallback = SystemFeignClientFallback.class)
public interface SystemFeignClient {

    @RequestMapping("/home/index")
    public String systemHomeIndex();
}
~~~
4. bootstrap.yml
ribbon、hystrix、openfeign的详细设置待补充