package spring02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) ctx.getBean("person5");
		System.out.println(person);

		Person2 person2 = (Person2) ctx.getBean("person6");
		System.out.println(person2);

		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getProperties());
		
	    Person person3 = (Person) ctx.getBean("person7");
		System.out.println(person3);
		
		person3 = (Person) ctx.getBean("person8");
		System.out.println(person3);
	}

}
