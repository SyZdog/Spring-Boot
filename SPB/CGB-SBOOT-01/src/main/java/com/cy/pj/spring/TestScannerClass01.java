package com.cy.pj.spring;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import ch.qos.logback.core.filter.Filter;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//通过@interface创建一个注解
@interface Component{}
//自定义一个类
@Component
class Containter{}

//这个类用来演示：SpringBoot启动时底层是如何加载类的，并创建实例
public class TestScannerClass01 {
	//自定创建beanPool去存储对象
	static Map<String, Object> beanpool = new HashMap<>();
	public static void main(String[] args) throws Exception {
		//目标：获取类的全限定名：包名+类名
		//======================获取包名========================
		//1.利用反射获取TestScannerClass01类的字节码对象
		Class<?> cls = TestScannerClass01.class;
		//2.根据字节码对象获取启动类所在包，com.cy.pk.spring
		String pkgName = cls.getPackage().getName();
		System.out.println(pkgName);
		//3.将包结构转换成目录结构
		String clsDir = pkgName.replace(".", "/");
		System.out.println(clsDir);
		//======================获取类名========================
		//4.获取目录所对应的类文件所在的目录（磁盘中的目录)
		URL url = ClassLoader.getSystemResource(clsDir);
		System.out.println(url);
		//5.获取URL对应的目录下所有的类（编译后的.class文件）
		File file = new File(url.getPath());
		//文件名的筛选
		String[] classNames = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".class");
			}
		});
		//6.加载类，根据类的配置信息，创建的实例
		for (String className : classNames) {
			//System.out.println(className);
			//获取类名
			String classShortName = className.substring(0, className.indexOf("."));
			//获取类的全限定名
			Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(pkgName+"."+classShortName);
			Component an = clazz.getAnnotation(Component.class);//获取注解
			if (an != null) {
				//利用反射去创建实例
				Object instences = clazz.newInstance();
				beanpool.put(classShortName, instences);
			}else {
				continue;
			}
			System.out.println(beanpool);
		}
	}

}
