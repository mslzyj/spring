package helloword;

public class CalculatorLoggingImpl implements Calculator{

	@Override
	public int add(int i, int j) {
		System.out.println("����add��ʼ["+i+","+j+"]");
		int result=i+j;
		System.out.println("����add����"+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("����sub��ʼ["+i+","+j+"]");
		int result=i-j;
		System.out.println("����sub����"+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("����mul��ʼ["+i+","+j+"]");
		int result=i*j;
		System.out.println("����mul����"+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("����div��ʼ["+i+","+j+"]");
		int result=i/j;
		System.out.println("����div����"+result);
		return result;
	}
}
