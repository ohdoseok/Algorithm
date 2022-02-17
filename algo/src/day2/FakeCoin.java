package PerComSubset;
import java.util.Scanner;

public class FakeCoin {
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();//Enter
		
		arr = new int[N+1];
		String[] s = sc.nextLine().split(" ");
		for(int i=1;i<=s.length;i++)
			arr[i] = Integer.parseInt(s[i-1]);
		
		System.out.println(recur(1, s.length-1));
	}
	
	public static int recur(int start, int end) {
		//홀수
		if((end-start+1)%2==1) end--; 
		
		int mid = (start+end-1)/2;
		int n1 = sum(start, mid);
		int n2 = sum(mid+1, end);
		//좌우 무게가 같으면
		if(n1 == n2) 
			return end+1;
		//2개일 때 종료
		if(end-start+1==2) {
			if(n1 < n2)
				return start;
			else
				return end;
		}
		
		//재귀
		if(n1 < n2)
			return recur(start, mid);
		else
			return recur(mid+1, end);
	}
	
	//저울에 무게 달기
	public static int sum(int start, int end) {
		int sum = 0;
		for(int i=start;i<=end;i++) {
			sum += arr[i];
		}
		return sum;
	}
}