//SWEA1208
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Solution1208 {
	public static void main(String[] args) {
		  	Scanner sc = new Scanner(System.in);
		  	
		  	int[] result = new int[11];
		  	for (int i = 1; i < 11; i++) {
		  		int Testcase = sc.nextInt();
		  		ArrayList<Integer> arr = new ArrayList<>();
				for (int j = 0; j < 100; j++) {
					arr.add(sc.nextInt());
				}
				for (int j = 0; j < Testcase; j++) {
					Collections.sort(arr);
					arr.set(99,Collections.max(arr)-1);
					arr.set(0, Collections.min(arr)+1);
				}
				result[i]=Collections.max(arr)-Collections.min(arr);
			}
		  	for (int j = 1; j < result.length; j++) {
		  		System.out.printf("#%d %d%n",j,result[j]);
			}
		  	
	}
}

