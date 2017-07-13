package spring07;

public class Car {
	private String brand;
	private double price;
	private double chang;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getChang() {
		return chang;
	}
	public void setChang(double chang) {
		this.chang = chang;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", chang=" + chang + "]";
	}


}
