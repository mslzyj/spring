package com.spring.tx.copy.xml;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.tx.copy.xml.service.BookShopService;
import com.spring.tx.copy.xml.service.Cashier;

public class SpringTranscationTest {
    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao=null;
    private BookShopService bookShopService=null;
    private Cashier cashier=null;
    {
    	ctx = new ClassPathXmlApplicationContext("applicationContext-tx-xml.xml");
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

}
