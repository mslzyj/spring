package spring03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * �Զ�װ��
 * ȱ�㣺1.autowire������bean�ļ����ϣ�һ��ָ�����͵�Ϊ��ǰbean��������������ʹ���Զ�װ�䣬�������
 *     2.һ��ָ���Զ�װ��ķ�ʽ��ֻ����byname��byType���������߶�ʹ��
 *    ��˲������Զ�װ�䣬���ϵ�������ܵ�ʱ����õ�
 * */
public class Main {

	public static void main(String[] args) {
	  ApplicationContext ctx = new ClassPathXmlApplicationContext("auto.xml");
	  Person per =(Person) ctx.getBean("person");
      System.out.println(per);
	}

}
