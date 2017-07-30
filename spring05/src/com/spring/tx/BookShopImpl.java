package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate JdbcTemplate;
	//������Ż�ȡ��ĵ���
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "SELECT price FROM `book` WHERE isbn=?";
		return JdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}
	 //������Ŀ�棬����Ŷ�Ӧ�Ŀ��-1
	@Override
	public void updateBookStock(String isbn) {
		//��������Ƿ��㹻�������������׳��쳣
		String sql2 = "SELECT stock FROM `book_stock` WHERE isbn=?";
		int stock =JdbcTemplate.queryForObject(sql2, Integer.class,isbn);
		if(stock==0){
			throw new BookStockException("��治�㣡");
		}
		String sql = "UPDATE `book_stock` SET stock = stock-1 WHERE isbn=?";
		JdbcTemplate.update(sql, isbn);

	}
	 //�����û����˻���ʹusername��balance-price
	@Override
	public void updateUserAccount(String username, int price) {
		//��֤����Ƿ��㹻�������������׳��쳣
		String sql2 = "SELECT balance FROM `account` WHERE username=?";
		int balance =JdbcTemplate.queryForObject(sql2, Integer.class,username);
		if(balance<price){
			throw new UserAccountException("���㣡");
		}
		String sql = "UPDATE `account` SET balance=balance-? WHERE username=?";
		JdbcTemplate.update(sql, price,username);

	}

}
