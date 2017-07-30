package com.spring.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hibernate.exception.BookStockException;
import com.spring.hibernate.exception.UserAccountException;

@Repository
public class BookShopDaoImpl implements BookShopDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// 不使用   private HibernateTemplate hibernateTemplate;因为这样会导致Dao和spring的api耦合，可移植性变差
	
	//获取跟当前线程绑定的Session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = " SELECT b.price FROM Book b  WHERE b.isbn=? ";
		Query query =getSession().createQuery(sql).setString(0, isbn);
		return (Integer) query.uniqueResult();
	}

	@Override
	public void updateBookStock(String isbn) {
		//检查书库存是否足够，若不够，则抛出异常
	   String sql2 = "SELECT b.stock FROM Book b  WHERE b.isbn=?";
	   int stock =(int) getSession().createQuery(sql2).setString(0, isbn).uniqueResult();
	   if(stock==0){
		 throw new BookStockException("库存不足");
	   }
	   String sql = "UPDATE Book b SET b.stock = b.stock-1 WHERE b.isbn=?";
	   getSession().createQuery(sql).setString(0, isbn).executeUpdate();

	}

	@Override
	public void updateUserAccount(String username, int price) {
		//验证余额是否足够，若不够，则抛出异常
		String sql2 = "SELECT a.blance FROM Account a WHERE a.username=?";
		int balance =(int) getSession().createQuery(sql2).setString(0, username).uniqueResult();
		if(balance<price){
			throw new UserAccountException("余额不足！");
		}
		String sql = "UPDATE Account a SET a.blance=a.blance-? WHERE a.username=?";
		getSession().createQuery(sql).setInteger(0, price).setString(1, username).executeUpdate();

	}

}
