package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate JdbcTemplate;
	//根据书号获取书的单价
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "SELECT price FROM `book` WHERE isbn=?";
		return JdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}
	 //更新书的库存，是书号对应的库存-1
	@Override
	public void updateBookStock(String isbn) {
		//检查书库存是否足够，若不够，则抛出异常
		String sql2 = "SELECT stock FROM `book_stock` WHERE isbn=?";
		int stock =JdbcTemplate.queryForObject(sql2, Integer.class,isbn);
		if(stock==0){
			throw new BookStockException("库存不足！");
		}
		String sql = "UPDATE `book_stock` SET stock = stock-1 WHERE isbn=?";
		JdbcTemplate.update(sql, isbn);

	}
	 //更新用户的账户余额，使username的balance-price
	@Override
	public void updateUserAccount(String username, int price) {
		//验证余额是否足够，若不够，则抛出异常
		String sql2 = "SELECT balance FROM `account` WHERE username=?";
		int balance =JdbcTemplate.queryForObject(sql2, Integer.class,username);
		if(balance<price){
			throw new UserAccountException("余额不足！");
		}
		String sql = "UPDATE `account` SET balance=balance-? WHERE username=?";
		JdbcTemplate.update(sql, price,username);

	}

}
