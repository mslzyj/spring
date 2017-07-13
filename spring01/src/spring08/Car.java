package spring08;

public class Car {
	public Car() {
		System.out.println("Car构造方法");
	}

	private String brand;

	public void setBrand(String brand) {
		System.out.println("setBrand");
		this.brand = brand;
	}

	public void init() {
		System.out.println("init");
	}

	public void destory() {
		System.out.println("destory");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
	
}
