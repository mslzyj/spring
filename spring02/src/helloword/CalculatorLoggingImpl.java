package helloword;

public class CalculatorLoggingImpl implements Calculator{

	@Override
	public int add(int i, int j) {
		System.out.println("方法add开始["+i+","+j+"]");
		int result=i+j;
		System.out.println("方法add结束"+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("方法sub开始["+i+","+j+"]");
		int result=i-j;
		System.out.println("方法sub结束"+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("方法mul开始["+i+","+j+"]");
		int result=i*j;
		System.out.println("方法mul结束"+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("方法div开始["+i+","+j+"]");
		int result=i/j;
		System.out.println("方法div结束"+result);
		return result;
	}
}
