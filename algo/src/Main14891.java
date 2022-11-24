import java.util.*;
public class Main14891 {
	public static void main(String[] args) {
		String[] array = new String[4];
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < 4 ; i++) {
			array[i] = sc.next();
		}
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			int num = sc.nextInt()-1;
			int check = sc.nextInt();
			int[] turn = new int[4];
			turn[num] = check;
			//왼쪽으로이동 하면서 체크
			for(int j = 1 ; j < 4 ; j++) {
				if(num-j < 0) {
					break;
				}
				if(checkRight(array[num-j]) != checkLeft(array[num-j+1])) {
					if(turn[num-j+1]==-1) {
						turn[num-j] = 1;
					}else if(turn[num-j+1]==1){
						turn[num-j] = -1;
					}
				}
			}
			for(int j = 1 ; j < 4 ; j++) {
				if(num+j > 3) {
					break;
				}
				if(checkLeft(array[num+j]) != checkRight(array[num+j-1])) {
					if(turn[num+j-1]==-1) {
						turn[num+j] = 1;
					}else if(turn[num+j-1]==1){
						turn[num+j] = -1;
					}
				}
			}
			for(int j = 0 ; j<4 ; j++) {
				array[j]=run(array[j],turn[j]);
			}
			
			
		}
		int res = 0;
		for(int i = 0 ; i < 4 ; i++) {
			if(array[i].charAt(0)=='1') {
				res+=Math.pow(2, i);
			}
		}
		System.out.println(res);
	}
	public static String run(String s, int check) {
		if(check == -1) {
			s = s.substring(1)+s.charAt(0);
			return s;
		}else if(check==1){
			s = s.charAt(7)+s.substring(0,7);
			return s;
		}
		return s;
	}
	public static char checkLeft(String s) {
		return s.charAt(6);
	}
	public static char checkRight(String s) {
		return s.charAt(2);
	}
}
