import java.util.Date;



public class InitializeDemo {
	private static int k = 1;
	private static InitializeDemo t1 = new InitializeDemo("t1");
	private static InitializeDemo t2 = new InitializeDemo("t2");
	private static int i = print("i");
	private static int n = 99;
	static {
		print("��̬��");
	}
	private int j = print("j");
	{
		print("�����");
	}
	public InitializeDemo(String str) {
		System.out.println((k++) + ":" + str + "   i=" + i + "    n=" + n);
		++i;
		++n;
	}
	public static int print(String str) {
		System.out.println((k++) + ":" + str + "   i=" + i + "    n=" + n);
		++n;
		return ++i;
	}
	public static void main(String args[]) {
//		new InitializeDemo("init");
		
		
		Date date=new Date();
		System.out.println(date.getDate());
		System.out.println(date.getDay());
		System.out.println(date.getTime());
	}
}