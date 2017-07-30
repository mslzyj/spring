package com.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.dao.BookShopDao;
import com.spring.hibernate.service.BookShopService;

@Service
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShapDao;
	/**
	 * Spring 事务的流程：
	 * 1.在方法之前：
	 * I 获取Session
	 * II 把Session和当前线程绑定，这样就可以在Dao汇总使用SessionFactory的getCurrentSession()方法来获取Session了
	 * III开启事务
	 * 2.若方法正常结束，即没有出现异常，则：
	 * I 提交事务
	 * II 使和当前线程绑定的Session接触绑定
	 * II 关闭Session
	 * 3.若方法出现异常，则：
	 * I 回滚事务
	 * II 使和当前线程绑定的Session接触绑定
	 * II 关闭Session
	 * 
	 */

	@Override
	public void purchase(String username, String isbn) {
		int price = bookShapDao.findBookPriceByIsbn(isbn);
		bookShapDao.updateBookStock(isbn);
		bookShapDao.updateUserAccount(username, price);

	}

}
