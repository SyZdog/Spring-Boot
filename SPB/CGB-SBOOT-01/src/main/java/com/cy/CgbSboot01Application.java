package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*@SpringBootApplication此注解描述的类为项目的启动类，也是入口，此类
 * 在启动时：
 * 1）自动化配置对象（springboot 提供了很多配置
 * 2）基于自动配置扫描启动类所在包以及包中的子类，并基于类上的描述
 * 对其对象进行管理
 * 
 * */

import ch.qos.logback.core.net.SyslogOutputStream;
@SpringBootApplication
public class CgbSboot01Application {
	public static void main(String[] args) {
		//获取字节码对象
		Class<?> clazz = CgbSboot01Application.class;
		//获取主启动类的包名，然后拿着包名可以进行扫描，然后去创建该包下面的类
		System.out.println(clazz.getPackage().getName());
		SpringApplication.run(CgbSboot01Application.class, args);
	}

}
