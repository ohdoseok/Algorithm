import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1228 {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {//총 10개
			int N = Integer.parseInt(br.readLine());//원본암호문의 길이
			int[] arrN = new int[N];//원본 암호문을 저장할 배열
			StringTokenizer st = new StringTokenizer(br.readLine());//원본암호문받음
			for (int j = 0; j < N; j++) {
				arrN[j] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());//명령어의 갯수
			StringTokenizer stM = new StringTokenizer(br.readLine());//모든 명령어를 받아왔다
			Queue<int[]> qu = new LinkedList<>(); //몇번째 부터 몇개를 어떤 값을 넣을지 정보를 저장할 큐
			int[] qusave;//큐에 저장할 배열
			for (int j = 0; j < M; j++) {//명령어를 돌면서 I면 원본 배열인 arrN에 삽입한다.				
				if (stM.nextToken().equals("I")) {//I라는 인서트라면 다음 명령어가 나올때 까지 insert
					int start = Integer.parseInt(stM.nextToken());//처음 시작 point를 start에 저장
					int cnt = Integer.parseInt(stM.nextToken());//몇개의 명령어를 삽입할껀지 정해주는 명령어수
					qusave = new int[cnt+2];//명령어의 수 +2만큼 만든다 시작번호와 갯수도 저장필요
					qusave[0] = start;
					qusave[1] = cnt;
					for (int k = 0; k < cnt; k++) {//명령어의 숫자만큼 받아서 배열에 저장
						qusave[k+2] = Integer.parseInt(stM.nextToken());//앞에 2개는 명령어의 시작점과 갯수를 저장해서 그뒤로 명령어 저장
					}
					qu.offer(qusave);//저장한 배열을 큐에 저장
				}//I를 만나면 뒤에있는 정보 모두 저장완료
			}//모든 명령어 수행완료 => 현재 모든 정보 큐에 저장
			//각 큐의 0번째 자리에 있는 숫자=n 1번째 자리에 있는 숫자m arr[n]부터 m개 삽입한다.
			for (int j = 0; j < M; j++) {//큐의 갯수나 명령어의 수나 동일
				Queue<Integer> arrNCp = new LinkedList<>();//원본배열을 옮겨주는 역할을 할 큐
				int[] resQ = qu.poll();//저장된 정보를 추출하는 결과큐
				int pln = 2;
				int n = resQ[0];//8
				int m = resQ[1];//2
				if (n<N) {
					for (int k = 0; k < arrN.length-n; k++) {
						arrNCp.offer(arrN[n+k]);//원본배열의  n부터 뒤는 모두다 옮긴다
					}
					if (n+m<=N) {
						for (int k = n; k < m + n; k++) {//원본배열의 n부터 m개를 삽입할것
							arrN[k] = resQ[pln];
							pln++;
						}
						if (n+m<N) {
							//삽입한 배열뒤로(m+1) 저장해둔 배열을 저장해줘야한다.
							for (int k = n+m; k < N; k++) {
								arrN[k]=arrNCp.poll();
							}
						}
					}else {
						for (int k = n; k < N; k++) {
							arrN[k] = resQ[pln];
							pln++;
						}
					}
				}
			}
			System.out.printf("#%d ",i+1);
			for (int j = 0; j < 10; j++) {
				System.out.printf("%d ",arrN[j]);
			}
			System.out.println();
		}

	}
}
