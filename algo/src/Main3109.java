import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3109 {//최대한 많이 검색하기 위해서는 앞으로 나아가되 위쪽부터 먼저 처리하는 방식으로 우상,우,우하 순서대로 처리한다.
	static char[][]map;
	static int res;
	static int Y;
	static int X;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		res = 0;
		map = new char[X][Y];
		for (int i = 0; i < X; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < X; i++) {
			check = false;
			search(i,0);
		}
		System.out.println(res);

	}
	static void search(int x,int y) {
		map[x][y] = 'x';
		if (y==Y-1) {
			res++;
			check = true;//목표에 도달하면 true
			return;
		}
		if (x-1>=0&&map[x-1][y+1]!='x'&&check==false) {//우상 배열에서 벗어나지않고 우상에 x가없으며 목표에 도달하지 못했다면
			search(x-1,y+1);
		}
		if (map[x][y+1]!='x'&&check==false) {//우
			search(x,y+1);
		}
		if (x+1<X&&map[x+1][y+1]!='x'&&check==false) {//우하
			search(x+1,y+1);
		}


	}
}
