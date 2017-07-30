package com.spring.tx;
//基于注解的方式
public interface BookShopDao {
   //根据书号获取书的单价
  public int findBookPriceByIsbn(String isbn);
   //更新书的库存，是书号对应的库存-1
  public void updateBookStock(String isbn);
  //更新用户的账户余额，使username的balance-price
  public void updateUserAccount(String username,int price);
}
