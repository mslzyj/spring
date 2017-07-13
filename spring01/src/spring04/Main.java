package spring04;
/*
 * bean之间的关系:1.继承
 * */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring03.Address;
import spring03.Person;

public class Main {

	public static void main(String[] args) {
	  ApplicationContext ctx = new ClassPathXmlApplicationContext("relation.xml");
	  Address address=(Address) ctx.getBean("address");
      System.out.println(address);
      
      address=(Address) ctx.getBean("address2");
      System.out.println(address);
      
      Person person=(Person)ctx.getBean("person");
      System.out.println(person);
	}

}
