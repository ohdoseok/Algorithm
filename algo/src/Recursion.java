
public class Recursion {
	public static void main(String[] args) {
		RE(9);
		System.out.println(sum(10));
		System.out.println(fac(0));
		System.out.println(ret(123));
		System.out.println(com("안녕하세요"));
		for (int i = 1; i < 11; i++) {
			System.out.printf("%d %n",fibo(i));
		}
		rec(3,"");
		
		
	}
	
	static void RE(int num) {//1~9출력
		System.out.println(num);
		if (num == 1) {
			return;
		}
		RE(num-1);
	}
	
	static int sum(int a) {//1~10합 출력
		if (a == 1) {
			return 1;
		}
		return a+sum(a-1);
	}
	
	static int fac(int a) {//팩토리얼
		if (a == 1 || a==0) {
			return 1;
		}
		return a*fac(a-1);
	}
	
	static int ret(int a) {//각 자리수의 합
		
		int mok = a/10;
		int nam = a%10;
		
		if (mok == 0) {
			return nam;
		}
		
		return nam + ret(mok);
	}
	
	static String com(String a) {//문자열 사이에 ,출력
		
		char[] arr = a.toCharArray();
		String copy = "";
		if (arr.length==1) {
			return String.valueOf(arr[0]);
		}
		for (int i = 1; i < arr.length; i++) {
			copy += arr[i];
		}
		
		return arr[0]+","+com(copy);
	}
	
	static int fibo(int a) {
		if (a == 1 || a == 2) {
			return 1;
		}
		return fibo(a-1)+fibo(a-2);
	}
	
	static void rec(int a, String b) {
		
		if(a==0) {
			System.out.println(b);
			return;
		}
		String res = b+"0";
		rec(a-1,res);
		
		res = b+"1";
		rec(a-1,res);
		
	}
	
}
