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
	 * Spring ��������̣�
	 * 1.�ڷ���֮ǰ��
	 * I ��ȡSession
	 * II ��Session�͵�ǰ�̰߳󶨣������Ϳ�����Dao����ʹ��SessionFactory��getCurrentSession()��������ȡSession��
	 * III��������
	 * 2.������������������û�г����쳣����
	 * I �ύ����
	 * II ʹ�͵�ǰ�̰߳󶨵�Session�Ӵ���
	 * II �ر�Session
	 * 3.�����������쳣����
	 * I �ع�����
	 * II ʹ�͵�ǰ�̰߳󶨵�Session�Ӵ���
	 * II �ر�Session
	 * 
	 */

	@Override
	public void purchase(String username, String isbn) {
		int price = bookShapDao.findBookPriceByIsbn(isbn);
		bookShapDao.updateBookStock(isbn);
		bookShapDao.updateUserAccount(username, price);

	}

}
