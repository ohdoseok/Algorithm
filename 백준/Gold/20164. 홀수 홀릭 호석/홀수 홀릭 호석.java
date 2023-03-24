import java.util.*;
import java.io.*;



public class Main
{
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ori = br.readLine();
		divid(ori,0);
		System.out.println(min+" "+max);
	}
	public static void divid(String ori,int sum) {
		
		for(int i = 0 ; i < ori.length() ; i++) {
			if((int)(ori.charAt(i)-'0') % 2 ==1) {
				sum++;
			}
		}
		if(ori.length()==1) {
			if(max < sum) {
				max = sum;
			}
			if(min > sum) {
				min = sum;
			}
			return;
		}else if(ori.length() == 2) {
			int val = (int)(ori.charAt(0)-'0')+(int)(ori.charAt(1)-'0');
			divid(String.valueOf(val),sum);
			return;
		}
		for(int i = 0 ; i < ori.length()-2 ; i++) {
			String one = ori.substring(0,i+1);
			for(int j = i+1 ; j < ori.length()-1 ; j++) {
				String two = ori.substring(i+1,j+1);
				String three = ori.substring(j+1,ori.length());
				int val = Integer.parseInt(one)+Integer.parseInt(two)+Integer.parseInt(three);
				divid(String.valueOf(val),sum);
			}
		}
	}
		
}