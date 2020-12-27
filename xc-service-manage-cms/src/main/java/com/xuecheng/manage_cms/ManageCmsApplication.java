package com.xuecheng.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author:dashuai
 * @ClassName:ManageCmsApplication
 * @Descirption:
 * @date:2020/12/22 9:55
 */
@SpringBootApplication
@EntityScan("com.xuecheng.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages={"com.xuecheng.api"})//扫描接口
@ComponentScan(basePackages="com.xuecheng.framework")//扫描common工程下的类
@ComponentScan(basePackages={"com.xuecheng.manage_cms"})//扫描接口
public class ManageCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class,args);
    }
}
