import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] secret = new int[M];
        int[] personArray = new int[N];
        for(int i = 0 ; i < M ; i++){
            secret[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            personArray[i] = Integer.parseInt(st.nextToken());
        }
        boolean ok = false;
        for(int i = 0 ; i <= N-secret.length ; i++){
            int cnt = 0;
            if(secret[0]==personArray[i]){
                cnt++;
                for(int j = 1 ; j < M ; j++){
                    if(personArray[i+j]!=secret[j]){
                        break;
                    }else{
                        cnt++;
                    }
                }
            }
            if(cnt == secret.length){
                ok = true;
                break;
            }
        }
        if(ok){
            System.out.println("secret");
        }else{
            System.out.println("normal");
        }
    }
}