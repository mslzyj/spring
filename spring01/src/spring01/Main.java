package spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
       public static void main(String[] args){
		/*HelloWord t = new HelloWord();
		t.setName("z");*/
        /*1.创建Spring的IOC容器
         * ClassPathXmlApplicationContext:是ApplicationContext 接口实现类，从类路径下来加载配置文件
         */
    	 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");   
        //2.从IOC容器中获取Bean实例
    	   //（1）利用id定位到IOC容器中的Bean
           HelloWord helloWord = (HelloWord)context.getBean("helloWord");
           //（2）利用类型返回IOC容器中的Bean，但要求IOC容器中必须只能有一个该类型的Bean
           //HelloWord helloword = context.getBean(HelloWord.class);
    	 
    	//3.调用方法	   
            helloWord.hello();
        
        Car car = (Car) context.getBean("car");
        System.out.println(car);
        
        car=(Car) context.getBean("car2");
        System.out.println(car);
        
        Person person = (Person) context.getBean("person");
        System.out.println(person);
        
        person = (Person) context.getBean("person2");
        System.out.println(person);
        
        person = (Person) context.getBean("person3");
        System.out.println(person);
        
        person = (Person) context.getBean("person4");
        System.out.println(person);
        
	}
}
