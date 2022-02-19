import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {

	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int PN = Integer.parseInt(br.readLine());
		for (int i = 0; i < PN; i++) {
			StringTokenizer stP = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(stP.nextToken());
			int arrnum = Integer.parseInt(stP.nextToken());
			if (sex == 1) {//남자면
				man(arrnum,1);
			}else {
				girl(arrnum,0);
			}
		}
		for (int i = 1; i < arr.length; i++) {
			if (i%20==0) {
				System.out.printf("%d",arr[i]);
				System.out.println();
			}else if(i==arr.length-1) {
				System.out.printf("%d",arr[i]);
			}else {
				System.out.printf("%d ",arr[i]);
			}
		}
	}
	
	
	static void man(int num,int mul) {
		if (num*mul>N) {
			return;
		}
		if (arr[num*mul]==1) {
			arr[num*mul]=0;
			man(num,mul+1);
		}else {
			arr[num*mul]=1;
			man(num,mul+1);
		}
		
	}
	
	
	static void girl(int num,int diff) {
		if (num-diff<1||num+diff>N) {
			return;
		}
		if (diff==0) {
			if (arr[num]==1) {
				arr[num]=0;
				girl(num,diff+1);
			}else {
				arr[num]=1;
				girl(num,diff+1);
			}
		}else {
			if (arr[num-diff]==arr[num+diff]) {
				if (arr[num-diff]==1) {
					arr[num-diff]=0;
					arr[num+diff]=0;
					girl(num,diff+1);
				}else {
					arr[num-diff]=1;
					arr[num+diff]=1;
					girl(num,diff+1);
				}
			}
		}
	}
}
