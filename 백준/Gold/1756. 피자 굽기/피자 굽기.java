import java.util.*;
import java.io.*;


public class Main
{
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//오븐의 깊이 
		int D = Integer.parseInt(st.nextToken());
		//피자 반죽의 개수
		int N = Integer.parseInt(st.nextToken());
		long[] tmpOven = new long[D];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < D ; i++) {
			tmpOven[i] = Long.parseLong(st.nextToken());
		}
		long[] oven = new long[D];
		long val = tmpOven[0];
		for(int i = 0 ; i < D ; i++) {
			if(tmpOven[i]>=val) {
				oven[i] = val;
			}else {
				val = tmpOven[i];
				oven[i] = val;
			}
		}
		long[] pizza = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			pizza[i] = Long.parseLong(st.nextToken());
		}
		int idx = oven.length-1;
		boolean ok = true;
		if(pizza[0]>oven[0]) {
			idx = 0;
		}else {
			for(int i = 0 ; i < pizza.length ; i++) {
				long pizzaL = pizza[i];
				if(idx<0) {
					ok = false;
					break;
				}
				for(int j = idx ; j >=0 ; j--) {
					if(oven[j]>=pizzaL) {
						idx = j-1;
						break;
					}
				}
			}
			if(!ok) {
				idx = 0;
			}else {
				idx += 2;
			}
		}
		
		System.out.println(idx);
	}
}