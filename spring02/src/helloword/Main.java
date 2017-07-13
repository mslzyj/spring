package helloword;

public class Main {
	public static void main(String[] args) {
//		Calculator aCalculator = null;
//		aCalculator = new CalculatorImpl();
//		int Result = aCalculator.add(3, 5);
//		System.out.println(Result);
//		Result = aCalculator.sub(3, 5);
//		System.out.println(Result);
//		Result = aCalculator.mul(3, 5);
//		System.out.println(Result);
//		Result = aCalculator.div(10, 5);
//		System.out.println(Result);
		
		Calculator target=new CalculatorImpl();
		Calculator proxy=new CalculatorProxy(target).getLoggingProxy();
		int result = proxy.add(1, 3);
		System.out.println(result);
		
	}
}
