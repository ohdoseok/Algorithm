package day2;

import java.util.Arrays;
import java.util.Scanner;

//순열을 nextpermutation으로 
public class NPTest {
	static int[] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		do {
			System.out.println(Arrays.toString(arr));
			
		} while (np());
	}
	static boolean np() {
		int i = N-1;
		while(i>0&&arr[i-1]>=arr[i]) {
			i--;
		}
		if (i==0) {
			return false;
		}
		int j = N-1;
		while(arr[i-1]>=arr[j]) {
			j--;
		}
		swap(i-1,j);
		int k = N-1;
		while(i<k) {
			swap(i,k);
			i++;
			k--;
		}
		return true;
	}
	static void swap(int a , int b) {
		int temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
	}
}
