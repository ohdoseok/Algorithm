/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution1225
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> qu = new LinkedList<Integer>();
			int[] arr = new int[8];
			int mok;
			int k = 0;
			while(st.hasMoreTokens()) {
				arr[k] = Integer.parseInt(st.nextToken());
				qu.offer(arr[k]);
				k++;
			}
			Arrays.sort(arr);
			if (arr[0]%15==0) {
				mok = ((arr[0]/15)-1)*15;
			}else {
				mok = (arr[0]/15)*15;
			}
			for (int j = 0; j < qu.size(); j++) {
				qu.offer(qu.poll()-mok);//
			}
			int j = 1;
			while(true) {
				if (j%6==0) {
					j++;
				}
				int res = qu.poll();
				if(res-(j%6)<=0) {
					qu.offer(0);
					break;
				}else {
					qu.offer(res-(j%6));
				}
				
				j++;
			}
			
			System.out.printf("#%d ",cnt);
			for (int j2 = 0; j2 < 8; j2++) {
				System.out.printf("%d ",qu.poll());
			}
			System.out.println();
		}
	}
}