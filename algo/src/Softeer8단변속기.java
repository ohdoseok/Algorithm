import java.util.*;
import java.io.*;


public class Softeer8단변속기
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[8];
        for(int i = 0 ; i < array.length ; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        int[] des = {8,7,6,5,4,3,2,1};
        int[] asc = {1,2,3,4,5,6,7,8};
        boolean OK = true;
        for(int i = 0 ; i < 8 ;i++){
            if(array[i]!=des[i]){
                OK = false;
                break;
            }
        }
        if(OK){
            System.out.println("descending");
        }else{
            OK = true;
            for(int i = 0 ; i < 8 ;i++){
                if(array[i]!=asc[i]){
                    OK = false;
                    break;
                }
            }
            if(OK){
                System.out.println("ascending");
            }else{
                 System.out.println("mixed");
            }
        }
        
    }
}