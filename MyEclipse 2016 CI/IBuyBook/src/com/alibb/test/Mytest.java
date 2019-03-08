package com.alibb.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibb.service.IBuyBook;

 

public class Mytest {
	private IBuyBook service;
	@Before
	public void before() {
		// 创建容器对象，加载Spring配置文件
		String resource = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		service = (IBuyBook) ac.getBean("buybookservice");
	}
	@Test
	public void  test01(){
		service.openu("杜玉", 10000);
		service.openb("红楼梦",45.0, 100);
	}
	@Test
	public void test02(){
		//service.buybook("杜玉","红楼梦", 2);
		//service.buybook("杜玉","围城", 10);
		service.buybook("杜玉","钢铁是怎样炼成的", 10);
	}
}
