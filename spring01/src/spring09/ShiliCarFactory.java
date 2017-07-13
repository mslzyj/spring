package spring09;

import java.util.HashMap;
/*
 * 实例工厂方法:实例工厂的方法，即需要创建工厂本身，再调用工厂的实例方法返回bean的实例
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
