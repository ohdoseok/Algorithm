import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
	public static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	//치킨집 리스트 
	public static List<Node> list = new ArrayList<>();
	//집 리스트 
	public static List<Node> houseList = new ArrayList<>();
	public static int min = Integer.MAX_VALUE;
	public static boolean[] check;
	public static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 1) {
					houseList.add(new Node(i,j));
				}else if(val == 2) {
					list.add(new Node(i,j));
				}
			}
		}
		check = new boolean[list.size()];
		dfs(0,0);
		bw.write(min + "\n");
        bw.flush();
        bw.close();
	
	}
	//총 치킨집에서 선택된 갯수만큼만 뽑아서 전체 길이의 합을 구한다.
	public static void dfs(int cnt, int start) {
		if(cnt==M) {
			int res = 0;
			for(int i = 0 ; i < houseList.size() ; i++) {
				int tmpRes = Integer.MAX_VALUE;
				for(int j = 0 ; j < list.size() ; j++) {
					if(check[j]) {
						int val = Math.abs(houseList.get(i).x - list.get(j).x) + Math.abs(houseList.get(i).y - list.get(j).y);
						tmpRes = Math.min(tmpRes, val);
						
					}
					
				}
				res+=tmpRes;
			}
			min = Math.min(min, res);
			return;
		}
		for(int i = start ; i < list.size() ; i++) {
			check[i] = true;
			dfs(cnt+1,start+1);
			check[i] = false;
		}
	}
}
