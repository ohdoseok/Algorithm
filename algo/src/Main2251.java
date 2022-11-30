import java.util.*;
public class Main2251 {
	public static int[] map;
	public static List<int[]> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		map = new int[3];
		list = new ArrayList<>();
		dfs(new int[]{0,0,C},new int[] {A,B,C});
		Collections.sort(list,new Comparator<int[]>() {
			@Override
			public int compare(int[] A, int[] B) {
				return A[2]-B[2];
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int[] Z : list) {
			if(Z[0]==0) {
				sb.append(Z[2]+" ");
			}
		}
		String res = sb.substring(0,sb.length()-1);
		System.out.println(res);
	}
	public static void dfs(int[] check, int[] ori) {
		for(int[] Z : list) {
			if(Z[0]==check[0]) {
				if(Z[1]==check[1]) {
					if(Z[2]==check[2]) {
						return;
					}
				}
			}
		}
		list.add(check);
		//start
		for(int i = 0 ; i < 3 ; i++) {
			
			if(check[i]==0) {
				continue;
			}
			//to
			for(int j = 0 ; j < 3 ; j++) {
				
				if(i==j) {
					continue;
				}
				int[] cpy = check.clone();
				//현재선택된 물통의 값
				int now = cpy[i];
				//옮길물통의 현재값
				int moveNow = cpy[j];
				//옮길 물통의 max값
				int maxMove = ori[j];
				
				if(moveNow+now > maxMove) {
					cpy[j] = maxMove;
					cpy[i] = now-(maxMove-moveNow); 
				}else {
					cpy[j] = moveNow+now;
					cpy[i] = 0;
				}
				dfs(cpy,ori);
			}
		}
	}
}
