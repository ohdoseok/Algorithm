import java.util.*;
import java.io.*;


public class Main
{
	static int res = -1;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long val = 9;
        int i = 1;
        while(M > val*i) {
        	M-=val*i;
        	val*=10;
        	i++;
        }
        long mok = (int)(M-1)/i;
        int nam = (int)(M-1)%i;
        long startnum = (long)Math.pow(10, i-1)+mok;
        if(startnum <= N) {
        	res = (int)(String.valueOf(startnum).charAt(nam)-'0');
        }
        System.out.println(res);
   }
}