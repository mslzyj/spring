package helloword;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
public class CalculatorProxy {
	//������Ķ���
	private Calculator target;
	
	public CalculatorProxy(Calculator target) {
		this.target = target;
	}

	//���ش���Ķ���
	public Calculator getLoggingProxy(){
		Calculator proxy=null;
		//�����������һ�������������
		ClassLoader loader = target.getClass().getClassLoader();
		//������������
		Class [] intterface=new Class[]{Calculator.class};
		//�����ô���������еķ���ʱ ����ִ�еĴ���
		InvocationHandler h= new InvocationHandler() {
			/*proxy:���ڷ����ĸ��������һ������£���invole�����в�ʹ�øö���
			 * method�����ڱ����õķ���
			 * args�����÷���ʱ������Ĳ���
			 * 
			 * */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				String methodName=method.getName();
				//��־
                System.out.println("The method"+methodName+"begins with"+Arrays.asList(args));
                //ִ�з���
                Object result =method.invoke(target, args);
                //��־
                System.out.println("The method"+methodName+"end with"+result);
				return result;
			}
		};
		
		//proxy=(Calculator)proxy.newProxyInstance(loader,intterface,h);
		return proxy;
	}

}
