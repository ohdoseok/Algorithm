import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        if(min > x){
            min = x;
        }
        if(min > y){
            min = y;
        }
        if(min > Math.abs(w-x)){
            min = Math.abs(w-x);
        }
        if(min > Math.abs(h-y)){
            min = Math.abs(h-y);
        }
        System.out.println(min);
    }
}