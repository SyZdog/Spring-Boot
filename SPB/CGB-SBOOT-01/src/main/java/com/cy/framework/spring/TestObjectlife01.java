package com.cy.framework.spring;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
//JVM中打印日志的参数：-XX:+PrintGCDetails
class Point{
	@Override
	protected void finalize() throws Throwable {
		System.out.println("==finalize==");
	}
}
//这个类用来测试对象的生命周期
public class TestObjectlife01 {

	public static void main(String[] args) {
		//1.创建对象
		//如果该对象只是创建，但没被引用，那他就是垃圾对象，但现在有一个p变量，指向point对象
		Point p = new Point();
		//p = null;//现在p没有指向Point对象，那现在point就是一个垃圾对象
		Object obj = createInstence();//obj是强引用
		//有obj引用指向point对象，所以不会触动gc去销毁对象
		//obj = null;
		//2.手动启动GC
		//System.gc();//启动gc时，系统会对内存中的对象进行可达性分析（判定对象是否是垃圾对象）
		//3.自动启动GC
		List<byte[]> list = new ArrayList();
		for (int i= 0; i<100000; i++) {
			list.add(new byte[1024*1024]);
			
		}
	}
	static Object createInstence() {
		Point p2 = new Point();
		return p2;
		
	}

}
