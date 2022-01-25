//백준 코딩테스트 1052 물병에 물을 계속 옮겨서 원하는 숫자가 되려면 몇개가 더필요한가
package com.coding.silver1;

import java.util.Scanner;

public class CodingTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int result = 0;
		for (int i = 0; i < K; i++) {
			int pow = 0;
			if (i==K-1) {
				while((int)Math.pow(2, pow)<N) {
					pow++;
				}
				result = Math.abs(N-(int)Math.pow(2, pow));
			}
			else {
				while((int)Math.pow(2, pow)<N) {
					pow++;
				}
				N = N-(int)Math.pow(2, pow-1);
			}
		}
		System.out.println(result);
	}
}
