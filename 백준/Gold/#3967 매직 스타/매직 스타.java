import java.util.*;
import java.io.*;


public class Main
{
	static boolean[] visit;
	static char[] fix = {'A','B','C','D','E','F','G','H','I','J','K','L'};;
	static boolean[] alpaCheck;
	static int[][] map = {{0,2,5,7},{0,3,6,10},{1,2,3,4},{1,5,8,11},{4,6,9,11},{7,8,9,10}};
	static boolean find = false;
	static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        
       char[] array = new char[12];
       //자리수에 대한 체크 
       visit = new boolean[12];
       
       //알파벳사용에 대한 체크 
       alpaCheck = new boolean[12];
       for(int i = 0 ; i < 5 ; i++) {
    	   String line = br.readLine();
    	   for(int j = 0 ; j < 9 ;j++) {
    		   char val = line.charAt(j);
    		   if(val!='.') {
    			   array[idx] = val;
    			   
    			   if(val!='x') {
    				   visit[idx] = true;
    				   for(int k = 0 ; k < 12 ; k++) {
    					   if(fix[k] == val) {
    						   alpaCheck[k] = true;
    					   }
    				   }
    			   }
    			   idx++;
    		   }
    	   }
       }
       dfs(array,0);
       System.out.println(sb.toString());
       
   }
    public static void dfs(char[] array, int idx) {
    	
    	if(idx == 12) {
    		boolean ok = true;
    		for(int i = 0 ; i < map.length ; i++) {
    			int val = 0;
    			for(int j = 0 ; j < map[i].length ; j++) {
    				char alpa = array[map[i][j]];
    				for(int k = 0 ; k < 12 ; k++) {
    					if(alpa == fix[k]) {
    						val+=k+1;
    					}
    				}
    			}
    			if(val != 26) {
    				ok = false;
    				break;
    			}
    		}
    		if(ok) {
    			find = true;
    			sb.append("...."+array[0]+"...."+'\n');
    			sb.append("."+array[1]+"."+array[2]+"."+array[3]+"."+array[4]+"."+'\n');
    			sb.append(".."+array[5]+"..."+array[6]+".."+'\n');
    			sb.append("."+array[7]+"."+array[8]+"."+array[9]+"."+array[10]+"."+'\n');
    			sb.append("...."+array[11]+"....");
    		}
    		return;
    	}
    	if(visit[idx]) {
    		dfs(array,idx+1);
    		if(find) {
    			return;
    		}
    	}else {
    		for(int i = 0 ; i < 12 ; i++) {
        		if(alpaCheck[i]) {
        			continue;
        		}
        		array[idx] = fix[i];
        		alpaCheck[i] = true;
        		dfs(array,idx+1);
        		alpaCheck[i] = false;
        		if(find) {
        			return;
        		}
        	}
    	}
    	
    }
}