package com.spring.tx;
//spring����,Ϊ��ʹ��������ͬʱ���У�����11�е�ע�⣺@Transactional
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
   @Autowired
	private BookShopDao bookShopDao;
   //�������ע��,������Ϊ�����Ĭ�ϵĴ�����ΪREQUIRED����ʹ�õ��÷���������
   //1.ʹ��Propagationָ�����񴫲���Ϊ
   //ʹ���µ�����
   //2.ʹ��isolationָ������ĸ��뼶����õ�ȡֵΪREAD_COMMITTED�������ύ��
   //Ĭ������£�spring����������������б������ʱ�쳣���лع���Ҳ����ͨ����Ӧ�����Խ������ã�ͨ��ȡĬ��ֵ 
   //3.noRollbackFord��UserAccountExceptionbuil�쳣���лع�
   //4.ʹ��readOnlyָ�������Ƿ�Ϊֻ�������԰������ݿ���������Ż����������һ��ֻ�����ݿ�ķ�����Ӧ����readOnly=true
   //5.ʹ��timeoutָ��ǿ�ƻع�֮ǰ�������ռ�õ�ʱ��timeout=3�룬����������ռ�õ�ʱ�䣬����������ռ��ʱ���������ǿ�ƻع�
   /*@Transactional(propagation=Propagation.REQUIRES_NEW,
    		isolation=Isolation.READ_COMMITTED,
    		noRollbackFor ={UserAccountException.class})*/
   @Transactional
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
