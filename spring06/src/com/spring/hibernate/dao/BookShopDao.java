package com.spring.hibernate.dao;
//����ע��ķ�ʽ
public interface BookShopDao {
   //������Ż�ȡ��ĵ���
  public int findBookPriceByIsbn(String isbn);
   //������Ŀ�棬����Ŷ�Ӧ�Ŀ��-1
  public void updateBookStock(String isbn);
  //�����û����˻���ʹusername��balance-price
  public void updateUserAccount(String username,int price);
}
