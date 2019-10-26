package com.fehead.sustdelivery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.fehead.sustdelivery"})
@MapperScan("com.fehead.sustdelivery.dao")
@EnableEurekaClient
@EnableSwagger2
//@EnableFeignClients
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
