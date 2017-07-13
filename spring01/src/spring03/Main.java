package spring03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * 自动装配
 * 缺点：1.autowire配置在bean的级别上，一旦指定，就得为当前bean的所有引用属性使用自动装配，不够灵活
 *     2.一旦指定自动装配的方式，只能是byname或byType，不能两者都使用
 *    因此不常用自动装配，整合第三方框架的时候会用到
 * */
public class Main {

	public static void main(String[] args) {
	  ApplicationContext ctx = new ClassPathXmlApplicationContext("auto.xml");
	  Person per =(Person) ctx.getBean("person");
      System.out.println(per);
	}

}
