package com.scott.neptune.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author scott
 */
@EnableSwagger2
@EntityScan(basePackages = "com.scott.neptune")
@ComponentScan(basePackages = "com.scott.neptune")
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
public class FileApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }

}
