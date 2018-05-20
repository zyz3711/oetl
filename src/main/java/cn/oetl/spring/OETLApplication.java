package cn.oetl.spring;

import org.apache.ibatis.annotations.Mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Configuration
@PropertySource(value = {"classpath:log4j.properties" }, ignoreResourceNotFound = true)
@ComponentScan(basePackages = "cn.oetl")
@MapperScan(value = {"cn.oetl.dao.mapper"})
public class OETLApplication extends SpringBootServletInitializer {
	
	// ？？、有问题 当部署到外部服务器时，注释掉下面的main，并打开这段代码
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(OETLApplication.class);
//    }
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(OETLApplication.class, args);
		// /oetl/WEB-INF/classes/views/news/news_index.jsp
	}
}
