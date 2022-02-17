import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1987 {
	static int Y;
	static int X;
	static char[][] map;
	static int res;
	static int sum;
	static ArrayList<Character> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y= Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new char[Y][X];
		sum = 1;//초기값
		res = Integer.MIN_VALUE;
		list = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}
		list.add(map[0][0]);//0,0의 문자는 저장하고 시작
		go(0,0);
		System.out.println(res);
		
	}
	static void go(int y , int x) {
		if (res == 26) {//a~z까지는 26개 모두 차면 더이상 탐색할 필요없이 그냥 리턴
			return;
		}
		for (int i = 0; i < 4; i++) {//4방탐색
			switch (i) {
			case 0://상
				if (y-1>=0) {
					if (search(y-1,x)) {
						sum++;
						go(y-1,x);
					}
				}
				break;
			case 1://우
				if (x+1<X) {
					if (search(y,x+1)) {
						sum++;
						go(y,x+1);
					}
				}
				break;
			case 2://하
				if(y+1<Y) {
					if (search(y+1,x)) {
						sum++;
						go(y+1,x);
					}
				}
				break;
			case 3://좌
				if (x-1>=0) {
					if (search(y, x-1)) {
						sum++;
						go(y,x-1);
					}
				}
				break;
			}
		}
		if (list.size()>0) {//4방탐색후 더이상 나아갈곳이 없다면 이전에 저장한문자를 제거하고 이전으로 돌아감
			list.remove(list.size()-1);
		}
		res = Math.max(res, sum);
		sum--;//이전으로 돌아가기때문에 sum-1
		
	}
	static boolean search(int y, int x) {//다음 지점을 search 하는데  위로 못가면 돌아와서 앞으로 못가면 돌아와서 아래탐색 못가면 돌아와서 왼쪽탐색 못가면 그전 자리로 이동 
		if (list.indexOf(map[y][x])!=-1) {//배열안에 있으면
			return false;
		}else {//배열안에 없으면
			list.add(map[y][x]);
			return true;
		}
	}
}
