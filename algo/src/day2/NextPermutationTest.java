package day2;
import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {//앞이랑 비교하면서 순열 
    static int N;
    static int[] input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        //0. 오름차순 정렬
        Arrays.sort(input); //제일 작은 순열이 무조건 하나 만들어짐
        
        do {
            //순열 출력
            System.out.println(Arrays.toString(input));
        }while(np());

    }
    private static boolean np() { //순열을 생성하면 true, 실패하면 false
        //1. 교환위치(꼭대기를 찾아서) 찾기
        int i = N-1; //마지막에서 찾기 시작
        while(i>0 && input[i-1] >= input[i]) {//맨 앞에까지갈수 있음으로
            i--;
        }
        //맨 앞에까지 왔거나
        if(i == 0) { //마지막 순열까지 다 구한상태
            return false;
        }
        //2. 꼭대기 찾음
        int j = N-1; //뒤에서 검색 시작
        while(input[i-1] >= input[j]) {
            j--;
        }
        //3. 교환위치(i-1)와 교환할값(j)교환하기
        swap(i-1, j);
        //4. 뒤 남은 자료 오름차순으로 정렬하기
        int k = N-1;
        while(i < k) { //원소의 갯수가 교환이 가능하다면
            swap(i,k);
            i++;
            k--;
        }
        return true;
    }
    static void swap(int i, int j) {
        int temp;
        temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}