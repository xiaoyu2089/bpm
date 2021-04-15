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

待引入Hystrix