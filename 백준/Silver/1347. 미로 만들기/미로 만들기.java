import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//시작점
		int startX = 0;
		int startY = 0;
		//바라보는방향
		int idx = 0;
		//Left기준 idx상승, Right는 idx감소
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int N = Integer.parseInt(br.readLine());
		String val = br.readLine();
		
		int LeftX = 0;
		int LeftY = 0;
		
		int RightX = 0;
		int RightY = 0;
		
		List<Node> list = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			char c = val.charAt(i);
			if(c == 'L') {
				idx = (idx+1)%4;
			}else if( c == 'R') {
				idx = (idx-1+4)%4;
			}else {
				 startX = startX+dx[idx];
				 startY = startY+dy[idx];
				 list.add(new Node(startX, startY));
				 if(startX < LeftX) {
					 LeftX = startX;
				 }
				 if(RightX < startX) {
					 RightX = startX;
				 }
				 if(startY < LeftY) {
					 LeftY = startY;
				 }
				 if(RightY < startY) {
					 RightY = startY;
				 }
			}
		}
		int x = Math.abs(LeftX)+Math.abs(RightX);
		int y = Math.abs(LeftY)+Math.abs(RightY);
		char[][] map = new char[x+1][y+1];
		startX = Math.abs(LeftX);
		startY = Math.abs(LeftY);
		map[startX][startY] = '.';
		for(int i = 0 ; i < list.size() ; i++) {
			Node node = list.get(i);
			map[startX+node.x][startY+node.y] = '.';
		}
		StringBuilder sb= new StringBuilder();
		for(int i = 0 ; i < x+1 ; i++) {
			for(int j = 0 ; j < y+1 ; j++) {
				if(map[i][j]!='.') {
					sb.append('#');
				}else {
					sb.append(map[i][j]);
				}
				
			}
			sb.append('\n');
		}
		String res = sb.substring(0,sb.length()-1);
		System.out.println(res);
	}
}
