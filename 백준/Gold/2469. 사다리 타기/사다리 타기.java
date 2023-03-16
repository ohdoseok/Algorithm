import java.util.*;
import java.io.*;


public class Main
{
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[][]map = new char[M+2][2*N-1];
		String res = br.readLine();
		//?가있는  row 의 idx
		int rowIdx = -1;
		for(int i = 1 ; i < map.length-1 ; i++){
			String row = br.readLine();
			if(row.charAt(0)!='?') {
				for(int j = 0 ; j < map[0].length ; j++) {
					if(j%2==1) {
						map[i][j] = row.charAt((int)j/2);
					}
				}
			}else {
				rowIdx = i;
			}
		}
		int[] dy = {-1,1};
		//위에서 내려왔을때 ?에 도달하기 직전까지 구하기 
		for(int i = 0 ; i < map[0].length ; i+=2) {
			//A는 65 
			int nowX = 0;
			int nowY = i;
			while(nowX<rowIdx) {
				for(int j = 0 ; j < 2 ; j++) {
					if(nowY+dy[j]<0 || nowY+dy[j]>=map[0].length) {
						continue;
					}
					if(map[nowX][nowY+dy[j]]=='-') {
						nowY = nowY+(dy[j]*2);
						break;
					}
				}
				map[nowX][nowY] = (char)((i/2)+65);
				nowX++;
			}
		}
		//아래에서 위로 올라왔을때 ?에 도달하기 직전까지 구하기
		for(int i = 0 ; i < map[0].length ; i+=2) {
			//A는 65 
			int nowX = map.length-1;
			int nowY = i;
			while(nowX>rowIdx) {
				for(int j = 0 ; j < 2 ; j++) {
					if(nowY+dy[j]<0 || nowY+dy[j]>=map[0].length) {
						continue;
					}
					if(map[nowX][nowY+dy[j]]=='-') {
						nowY = nowY+(dy[j]*2);
						break;
					}
				}
				map[nowX][nowY] = res.charAt(i/2);
				nowX--;
			}
		}
		//체크를 해서 ? 에 들어갈 사다리를 만들어냄 
		//3가지 경우의 수 -> 사다리가 없어서 바로 내려가던가 사다리를 통해 오른쪽, 왼쪽으로 이동하던가 
		for(int i = 0 ; i < map[0].length ; i+=2) {
			if(rowIdx == 0 || rowIdx == M-1) {
				
			}
			//그대로 내려갔다면 
			if(map[rowIdx-1][i] == map[rowIdx+1][i]) {
				if(i+1<map[0].length) {
						map[rowIdx][i+1] = '*';
				}
				if(i-1>=0) {
						map[rowIdx][i-1] = '*';
				}
			}//내려갔는데 왼쪽에 존재 
			else if(i-2>=0 && map[rowIdx-1][i]==map[rowIdx+1][i-2]) {
					map[rowIdx][i-1] = '-';
					if(i+1<map[0].length) {
						map[rowIdx][i+1] = '*';
					}
			}//내려갔는데 오른쪽에 존재 
			else if(i+2<map[0].length && map[rowIdx-1][i]==map[rowIdx+1][i+2]) {
				map[rowIdx][i+1] = '-';
				if(i-1>=0) {
					map[rowIdx][i-1] = '*';
				}
			}//바로아래도, 왼쪽에도, 오른쪽에도 존재하지 않는다면 잘못된 사다리 
			else {
				break;
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < map[0].length ; i+=2) {
			if(map[rowIdx][i] != '*' && map[rowIdx][i] != '-') {
				sb = new StringBuilder();
				for(int j = 1 ; j < map[0].length ; j+=2) {
					sb.append('x');
				}
				break;
			}else {
				sb.append(map[rowIdx][i]);
			}
		}
		System.out.println(sb.toString());
//		for(int i = 0 ; i < map.length ; i++) {
//			for(int j = 0 ; j < map[i].length ; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
}