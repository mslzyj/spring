package spring09;

import java.util.HashMap;
/*
 * ʵ����������:ʵ�������ķ���������Ҫ�������������ٵ��ù�����ʵ����������bean��ʵ��
 * 
 * */
import java.util.Map;

public class ShiliCarFactory {
	private Map<String, Car> cars = null;

	public ShiliCarFactory() {
		cars = new HashMap<String, Car>();
		cars.put("dazhong", new Car("dazhong", 250000));
		cars.put("ford", new Car("ford", 280000));
	}
	public Car getCar(String brand){
		return cars.get(brand);
	}
}
