import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1592 {
	static int[] arrN;
	static int N;
	static int M;
	static int L;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arrN = new int[N];
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		go(0,0);
		System.out.println(res-1);

	}
	static void go(int start,int cnt) {
		if (arrN[start]==M) {
			res=cnt;
			return;
		}
		if (arrN[start]==0) {
			arrN[(start+L)%N]++;
			go((start+L)%N,cnt+1);
		}else {
			if( arrN[start]%2==1) {//홀수면 시계방향으로
				arrN[(start+L)%N]++;
				go((start+L)%N,cnt+1);
			}else {
				if (start-L<0) {
					arrN[start-L+N]++;
					go(start-L+N,cnt+1);
					
				}
				else {
					arrN[(start-L)%N]++;
					go((start-L)%N,cnt+1);
				}
				
			}
		}
		
	}
}
