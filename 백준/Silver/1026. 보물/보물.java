import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
       int [][] Array = new int[2][N];

       for(int i = 0 ; i < 2 ; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int j = 0 ; j < N ;j++){
               int s = Integer.parseInt(st.nextToken());
               Array[i][j] = s;
           }
       }
       int sum = 0;
       for(int i = 0 ; i < N ; i++){
           int min = Integer.MAX_VALUE;
           int max = Integer.MIN_VALUE;
           int tmpA = 0;
           int tmpB = 0;
           for(int j  = 0 ; j < N ; j++){
               if(min > Array[0][j]){
                   min = Array[0][j];
                   tmpA = j;
               }
               if(max < Array[1][j]){
                   max = Array[1][j];
                   tmpB = j;
               }
           }
           sum=sum+(min*max);
           Array[0][tmpA] = Integer.MAX_VALUE;
           Array[1][tmpB] = Integer.MIN_VALUE;
       }
        System.out.println(sum);
    }
}