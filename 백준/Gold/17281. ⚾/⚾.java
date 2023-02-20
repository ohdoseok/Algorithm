import java.util.*;
import java.io.*;


public class Main
{
	public static int max = Integer.MIN_VALUE;
	public static boolean[] check = new boolean[9];
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][9];
        for(int i = 0 ; i < N ; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < 9 ; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        int[] array = new int[9];
        array[3] = 0;
        check[0] = true;
        dfs(0,array,map);
        System.out.println(max);
    }
   public static void dfs(int cnt, int[] array, int[][] map) {
	   
	   if(cnt == 9) {
		   int idx = 0;
		   int res = 0;
		   for(int i = 0 ; i< map.length ; i++) {
			   int outCnt = 0;
//			   Queue<Integer> q = new LinkedList<>();
			   boolean[] base = new boolean[3];
			   while(outCnt<3) {
				   int person = array[idx];
				   int val = map[i][person];
				   switch(val) {
				   case 0:
					   outCnt++;
					   break;
				   case 1:
					   if(base[2]) {
						   res++;
						   base[2] = false;
					   }
					   if(base[1]) {
						   base[2] = true;
						   base[1] = false;
					   }
					   if(base[0]) {
						   base[1] = true;
						   base[0]= false;
					   }
					   base[0] = true;
					   break;
				   case 2:
					   if(base[2]) {
						   res++;
						   base[2] = false;
					   }
					   if(base[1]) {
						   res++;
						   base[1] = false;
					   }
					   if(base[0]) {
						   base[2] = true;
						   base[0] = false;
					   }
					   base[1] = true;
					   break;
				   case 3:
					   if(base[2]) {
						   res++;
						   base[2] = false;
					   }
					   if(base[1]) {
						   res++;
						   base[1] = false;
					   }
					   if(base[0]) {
						   res++;
						   base[0] = false;
					   }
					   base[2] = true;
					   break;
				   case 4:
					   if(base[2]) {
						   res++;
						   base[2] = false;
					   }
					   if(base[1]) {
						   res++;
						   base[1] = false;
					   }
					   if(base[0]) {
						   res++;
						   base[0] = false;
					   }
					   res++;
					   break;
				   }
				   idx = (idx+1)%9;
			   }
		   }
		   if(max < res) {
			   max = res;
		   }
		   return;
	   }
	   if(cnt!=3) {
		   for(int i = 1 ; i < 9 ; i++) {
			   if(check[i]) {
				   continue;
			   }
			   check[i] = true;
			   array[cnt] = i;
			   dfs(cnt+1, array, map);
			   check[i] = false;
		   }
	   }else {
		   dfs(cnt+1,array,map);
	   }
	   
   }
}