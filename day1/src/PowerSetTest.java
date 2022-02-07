import java.util.Scanner;

public class PowerSetTest {
    static int N;
    static int[] input;
    static boolean[] v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        v = new boolean[N];
        for(int i = 0; i < N; i++) {
            input[i]= sc.nextInt();
        }

        subSet(0);
    }

    static void subSet(int cnt) { // 부분집합에 고려해야 하는 원소 위치
        //종료 조건
        if(cnt == N) {//마지막 원소까지 고려한 상황
            //선택된 파워셋 구한 후 추력
            for(int i = 0; i < N; i++) {
                System.out.print((v[i] ? input[i] : "X") + " ");
            }
            System.out.println();
            return;
        }


        //파워셋 처리
        //현재 원소 선택
        v[cnt] = true;
        subSet(cnt + 1);

        //현재 원소 비선택
        v[cnt] = false;
        subSet(cnt + 1);
    }

}