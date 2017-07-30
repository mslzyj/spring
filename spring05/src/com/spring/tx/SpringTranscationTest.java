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
    //测试事务的传播行为
    @Test
    public void testTranscationlPropagation(){
    	cashier.checkout("a", Arrays.asList("1001","1002"));
    }
    //测试事务
    @Test
    public void testBookShopService(){
    	bookShopService.purchase("a", "1001");
    }
    
    
    //根据书编号查询价格
	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}
	//使库存数量减1
    @Test
    public void testupdateBookStock(){
    	bookShopDao.updateBookStock("1001");
    }
    //更新用户的账户余额，使username的balance-price
    @Test
    public void testupdateUserAccount(){
    	bookShopDao.updateUserAccount("a", 100);
    }
}
