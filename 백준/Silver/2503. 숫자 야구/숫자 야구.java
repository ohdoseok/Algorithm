import java.io.*;
import java.util.*;
public class Main {
	public static boolean[] check = new boolean[10];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		dfs(q,0,sb);
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmpval = st.nextToken();
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			int size = q.size();
			for(int j = 0 ; j < size ; j++) {
				String orgval = q.poll();
				int tmpStrike = strike;
				int tmpBall = ball;
				//숫자 두개를 비교시에 모든 경우를 다 비교해서 조건에 맞게 0 ,0 이 나와야 한다. 그 이상의 경우 -까지도 내려 가는데 이렇게 되면 조건을 만족하지 않는다는 
				for(int k = 0 ; k < 3 ; k++) {
					for(int l = 0 ; l < 3 ; l++) {
						if(k==l && tmpval.charAt(k)==orgval.charAt(l)) {
							tmpStrike--;
						}
						if(k!=l && tmpval.charAt(k)==orgval.charAt(l)) {
							tmpBall--;
						}
					}
				}
				if(tmpStrike == 0 && tmpBall == 0) {
					q.offer(orgval);
				}
			}
		}
		System.out.println(q.size());
				
	}
	public static void dfs(Queue<String> q, int cnt, StringBuilder val) {
		if(cnt == 3) {
			q.offer(val.toString());
			return;
		}
		for(int i = 1 ; i < 10 ; i++) {
			if(check[i]) {
				continue;
			}
			char c = (char) (i+'0');
			val.append(c);
			check[i] = true;
			dfs(q,cnt+1,val);
			val.deleteCharAt(val.length()-1);
			check[i] = false;
		}
	}
}
