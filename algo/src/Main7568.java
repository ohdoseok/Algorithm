import java.util.*;
public class Main7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int[][] map = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
		}
		int[] array = new int[N];
		Arrays.fill(array,1);
		for(int i = 0 ; i < map.length ; i++) {
			
			for(int j = 0 ; j < map.length ; j++) {
				if(map[i][0] < map[j][0] && map[i][1] < map[j][1]) {
					array[i]++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i : array) {
			sb.append(i+" ");
		}
		String res = sb.substring(0,sb.length()-1);
		System.out.println(res);
	}
}
