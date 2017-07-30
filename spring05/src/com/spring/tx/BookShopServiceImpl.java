package com.spring.tx;
//spring事务,为了使两个动作同时进行，即第11行的注解：@Transactional
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
   @Autowired
	private BookShopDao bookShopDao;
   //添加事务注解,括号里为事务的默认的传播行为REQUIRED，即使用调用方法的事务
   //1.使用Propagation指定事务传播行为
   //使用新的事务
   //2.使用isolation指定事务的隔离级别，最长用的取值为READ_COMMITTED（读已提交）
   //默认情况下，spring的声明是事务对所有别的运行时异常进行回滚，也可以通过对应的属性进行设置，通常取默认值 
   //3.noRollbackFord对UserAccountExceptionbuil异常进行回滚
   //4.使用readOnly指定事务是否为只读，可以帮助数据库引擎进行优化，若真的是一个只读数据库的方法，应设置readOnly=true
   //5.使用timeout指定强制回滚之前事务可以占用的时间timeout=3秒，缩短了事务占用的时间，若果事务所占的时间过长，则强制回滚
   /*@Transactional(propagation=Propagation.REQUIRES_NEW,
    		isolation=Isolation.READ_COMMITTED,
    		noRollbackFor ={UserAccountException.class})*/
   @Transactional
	@Override
	public void purchase(String username, String isbn) {
		//获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//更新书的库存
		bookShopDao.updateBookStock(isbn);
		//更新用户余额
		bookShopDao.updateUserAccount(username, price);
		
	}
  
}
