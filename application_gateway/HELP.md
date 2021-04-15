#SpringCound Gateway项目

1. 注意 SpringCloud gateway是基于webflux的，所以会和spring-boot-starter-web（MVC）
产生冲突。具体配置如下
   * 确保父项目的dependency中没有全局引用spring-boot-starter-web
   * Gateway项目的POM文件，需要自己引用WebFlux的Stater
   * 在Gateway的starter中exclude stater-web和 starter-webflux