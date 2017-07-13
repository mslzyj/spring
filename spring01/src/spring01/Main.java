package spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
       public static void main(String[] args){
		/*HelloWord t = new HelloWord();
		t.setName("z");*/
        /*1.����Spring��IOC����
         * ClassPathXmlApplicationContext:��ApplicationContext �ӿ�ʵ���࣬����·���������������ļ�
         */
    	 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");   
        //2.��IOC�����л�ȡBeanʵ��
    	   //��1������id��λ��IOC�����е�Bean
           HelloWord helloWord = (HelloWord)context.getBean("helloWord");
           //��2���������ͷ���IOC�����е�Bean����Ҫ��IOC�����б���ֻ����һ�������͵�Bean
           //HelloWord helloword = context.getBean(HelloWord.class);
    	 
    	//3.���÷���	   
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
