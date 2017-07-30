package com.spring.tx.copy.xml.service.impl;

import com.spring.tx.copy.xml.BookShopDao;
import com.spring.tx.copy.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {
	private BookShopDao bookShopDao;
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
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
