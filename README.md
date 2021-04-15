# 微服务测试项目

1. 创建父项目，简单的用一个MavenProject就可以
* 设置Parent
~~~
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.8.RELEASE</version>
        <relativePath />
</parent>
~~~

* 设置dependencyManagement
~~~
<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Greenwich.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
                <version>${alibaba.cloud.version}</version>
            </dependency>
<!--            <dependency>-->
<!--                <groupId>com.alibaba.cloud</groupId>-->
<!--                <artifactId>spring-cloud-alibaba-dependencies</artifactId>-->
<!--                <version>2.1.0.RELEASE</version>-->
<!--                <type>pom</type>-->
<!--                <scope>import</scope>-->
<!--            </dependency>-->

        </dependencies>
    </dependencyManagement>
~~~
* 设置dependencies
~~~
<dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
</dependencies>
~~~

* 设置build插件
~~~
<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <skip>true</skip>
                </configuration>
            </plugin>
        </plugins>
    </build>
~~~

注意SpringBoot、SpringCould和 alibaba Cloud对应的版本关系

## 增加zipkin文件，sluth结合zipkin 实现微服务链路追踪。 zipkin可以基于mysql和es
1. 下载zipkin单独部署，启动。默认端口9411
2. 分别在每个微服务中增加POM依赖
~~~
<!-- 这个依赖包含了sleuth和zipkin -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zipkin</artifactId>
        </dependency>
~~~
3. 分别在每个微服务的资源文件中增加配置信息
~~~
spring:
  application:
    name: service_order
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848
  zipkin:
    base-url: http://localhost:9411/  # zipkin服务器的地址
    sender:
      type: web  # 设置使用http的方式传输数据
    sleuth:
      sampler:
        probability: 1  # 设置抽样采集为100%，默认为0.1，即10%
~~~

