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
		//��ȡ��ĵ���
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//������Ŀ��
		bookShopDao.updateBookStock(isbn);
		//�����û����
		bookShopDao.updateUserAccount(username, price);
		
	}
  
}
