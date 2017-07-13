package spring09;
import java.util.HashMap;
import java.util.Map;
/*
 * ��̬����������ֱ�ӵ���һ����ľ�̬�����Ϳ��Է���Bean��ʵ��
 * */
public class StaticCarFactor {
		private  static Map<String,Car> cars=new HashMap<String,Car>();
		static{
			cars.put("baoma", new Car("baoma",200000));
			cars.put("benchi",new Car("benchi",300000));
		}
		//��̬��������
	   public static Car getCar(String name){
		   return cars.get(name);
	   }
}
