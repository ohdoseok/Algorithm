import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1956 {
	public static int[][] dis;
	public static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int nodeCount = Integer.parseInt(st.nextToken());
		dis = new int[node][node];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis[i].length; j++) {
				if (i==j) {
					dis[i][j]=0;
				}else {
					dis[i][j]=99999;
				}
				
			}
		}
		
		for (int i = 0; i < nodeCount; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st2.nextToken())-1;
			int to = Integer.parseInt(st2.nextToken())-1;
			int val = Integer.parseInt(st2.nextToken());
			dis[from][to] = val;
		}
		
		for (int n = 0; n < node; n++) {
			for (int i = 0; i < dis.length; i++) {
				for (int j = 0; j < dis[i].length; j++) {
					if (dis[i][j] > dis[i][n]+dis[n][j]) {
						dis[i][j] = dis[i][n]+dis[n][j];
					}
				}
			}
		}
		for (int i = 0; i < dis.length; i++) {
			for (int j = i; j < dis[i].length; j++) {
				if (i!=j && dis[i][j]+dis[j][i]<res) {
					res = dis[i][j]+dis[j][i];
				}
			}
		}
		System.out.println(res);
	}
}
