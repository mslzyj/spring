package helloword;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
public class CalculatorProxy {
	//到代理的对象
	private Calculator target;
	
	public CalculatorProxy(Calculator target) {
		this.target = target;
	}

	//返回代理的对象
	public Calculator getLoggingProxy(){
		Calculator proxy=null;
		//代理对象由哪一个类加载器加载
		ClassLoader loader = target.getClass().getClassLoader();
		//代理对象的类型
		Class [] intterface=new Class[]{Calculator.class};
		//当调用代理对象其中的方法时 ，该执行的代码
		InvocationHandler h= new InvocationHandler() {
			/*proxy:正在返回哪个代理对象，一般情况下，在invole方法中不使用该对象
			 * method：正在被调用的方法
			 * args：调用方法时，传入的参数
			 * 
			 * */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				String methodName=method.getName();
				//日志
                System.out.println("The method"+methodName+"begins with"+Arrays.asList(args));
                //执行方法
                Object result =method.invoke(target, args);
                //日志
                System.out.println("The method"+methodName+"end with"+result);
				return result;
			}
		};
		
		//proxy=(Calculator)proxy.newProxyInstance(loader,intterface,h);
		return proxy;
	}

}
