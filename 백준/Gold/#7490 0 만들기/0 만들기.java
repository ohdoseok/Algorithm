import java.util.*;
import java.io.*;


public class Main
{
	static char[]  array = {'+','-',' '};
//	static Map<Integer,String> map ;
	static List<String> resList;
	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int time = 0 ; time < N ; time++) {
        	resList = new ArrayList<>();
        	int val = Integer.parseInt(br.readLine());
        	int goal = val-1;
        	List<Character> list = new ArrayList<>();
        	int[] tmpval = new int[val];
        	for(int i = 0 ; i < val ; i++) {
        		tmpval[i] = i+1;
        	}
        	dfs(goal,0,list,tmpval);
        	Collections.sort(resList, new Comparator<String>() {
        		@Override
        		public int compare(String s1, String s2) {
        			return s1.compareTo(s2);
        		}
        	});
        	for(int i = 0 ; i < resList.size() ;i++) {
        		System.out.println(resList.get(i));
        	}
        	System.out.println();
        }
    }
    public static void dfs(int goal, int cnt, List<Character> list, int[] val) {
    	if(cnt == goal) {
    		StringBuilder sb = new StringBuilder();
    		int sum = 0;
    		char prev = ' ';
    		for(int i = 0 ; i < list.size() ; i++) {
    			String res = String.valueOf(val[i]);
    			while(i < list.size() && list.get(i)==' ') {
    				i++;
    				res+= String.valueOf(val[i]);
    			}
    			switch(prev) {
    			case '+':
    				sum+=Integer.parseInt(res);
    				break;
    			case '-':
    				sum-=Integer.parseInt(res);
    				break;
    			case ' ':
    				sum = Integer.parseInt(res);
    				break;
    			}
    			if(i<list.size()) {
    				prev = list.get(i);
    				if(i==list.size()-1) {
        				if(prev=='+') {
        					sum+=val[i+1];
        				}else {
        					sum-=val[i+1];
        				}
        			}
    			}
    			
    			
    		}
    		if(sum==0) {
    			for(int i = 0 ; i < list.size() ; i++) {
    				sb.append(val[i]);
    				sb.append(list.get(i));
    			}
    			sb.append(val[val.length-1]);
    			resList.add(sb.toString());
    		}
    		
    		return;
    	}
    	for(int j = 0 ; j < 3 ; j++) {
			list.add(array[j]);
			dfs(goal,cnt+1,list,val);
			list.remove(cnt);
		}
    }
   
}