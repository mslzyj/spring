package spring10;

import org.springframework.beans.factory.FactoryBean;
//自定义Factory实现接口 FactoryBean<Car>
public class CarFactoryBean implements FactoryBean<Car> {
     private String brand;
     public void setBrand(String brand) {
		this.brand = brand;
	}
	//返回bean的对象
	@Override
	public Car getObject() throws Exception {
		// TODO Auto-generated method stub
		return  new Car(brand, 30000);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
