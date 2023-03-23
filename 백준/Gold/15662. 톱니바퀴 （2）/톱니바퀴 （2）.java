import java.util.*;
import java.io.*;



public class Main
{
	static boolean[] check;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] array = new String[N];
		for(int i = 0 ; i < N ; i++) {
			array[i] = br.readLine();
		}
		int T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken())-1;
			int turn = Integer.parseInt(st.nextToken());
			check = new boolean[N];
			int[] turnArray = new int[N];
			turnArray[idx] = turn;
			checkTurn(array,idx,turnArray);
			for(int j = 0 ; j < turnArray.length ; j++) {
				if(turnArray[j]==-1) {
					turnL(j,array);
				}else if(turnArray[j]==1) {
					turnR(j,array);
				}
			}
		}
		int res = 0;
		for(String val : array) {
			if(val.charAt(0)=='1') {
				res++;
			}
		}
		System.out.println(res);
	}
	public static void checkTurn(String[] array , int idx , int[] turnArray) {
		if(idx+1<array.length && !check[idx+1] && array[idx].charAt(2)!=array[idx+1].charAt(6)) {
			check[idx] = true;
			turnArray[idx+1] = turnArray[idx]==-1 ? 1 : -1;
			checkTurn(array,idx+1, turnArray);
		}
		if(idx-1>=0 && !check[idx-1] && array[idx].charAt(6)!=array[idx-1].charAt(2)) {
			check[idx] = true;
			turnArray[idx-1] = turnArray[idx]==-1 ? 1 : -1;
			checkTurn(array,idx-1,turnArray);
		}
	}
	//반시계방향 
	public static void turnL(int idx, String[] array) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i< array[idx].length() ; i++) {
			sb.append(array[idx].charAt(i));
		}
		sb.append(array[idx].charAt(0));
		array[idx] = sb.toString();
	}
	//시계방향 
	public static void turnR(int idx, String[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append(array[idx].charAt(array[idx].length()-1));
		for(int i = 0 ; i< array[idx].length()-1 ; i++) {
			sb.append(array[idx].charAt(i));
		}
		array[idx] = sb.toString();
	}
		
}