import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
//최소비용으로 그 다음에 자신을 제외한 모든것에 합 자신의 자리에는 두번째 비용을합 => 최종에서 가장작은값을 출력하면 그값이 최소값
public class Main1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][]map = new int[T][3];
		int[][]input = new int[T][3];
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = 0;
		int secmin = 0;
		int minidx = 0;
		for (int i = 0; i < map.length; i++) {
			List<Integer> list = new ArrayList<Integer>();;
			for (int j = 0; j < map[i].length; j++) {
				if (j!=minidx) {
					list.add(map[i][j]+min);
				}else {
					list.add(map[i][j]+secmin);
				}
			}
			min = Collections.min(list);
			minidx = list.indexOf(min);
			list.remove(minidx);
			secmin = Collections.min(list);
		}
		System.out.println(min);
	}
}

