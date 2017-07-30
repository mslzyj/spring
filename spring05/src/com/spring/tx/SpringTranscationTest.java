package com.spring.tx;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTranscationTest {
    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao=null;
    private BookShopService bookShopService=null;
    private Cashier cashier=null;
    {
    	ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	bookShopDao=ctx.getBean(BookShopDao.class);
    	bookShopService=ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }
    //��������Ĵ�����Ϊ
    @Test
    public void testTranscationlPropagation(){
    	cashier.checkout("a", Arrays.asList("1001","1002"));
    }
    //��������
    @Test
    public void testBookShopService(){
    	bookShopService.purchase("a", "1001");
    }
    
    
    //�������Ų�ѯ�۸�
	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}
	//ʹ���������1
    @Test
    public void testupdateBookStock(){
    	bookShopDao.updateBookStock("1001");
    }
    //�����û����˻���ʹusername��balance-price
    @Test
    public void testupdateUserAccount(){
    	bookShopDao.updateUserAccount("a", 100);
    }
}
