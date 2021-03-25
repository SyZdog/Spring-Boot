package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * (异步自动配置生效)
 * @EnableCaching 注解表示启动缓存配置
 * @author zdzsmacbookpro
 *
 */
@EnableCaching
@SpringBootApplication
public class CgbDbSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgbDbSysApplication.class, args);
	}

}
