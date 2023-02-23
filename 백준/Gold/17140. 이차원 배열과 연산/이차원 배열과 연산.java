import java.util.*;
import java.io.*;


public class Main
{
	static class Node{
		int val;
		int cnt;
		Node(int val, int cnt){
			this.cnt = cnt;
			this.val = val;
		}
	}
	static class NodeCom implements Comparator<Node>{
		
		@Override
		public int compare(Node o1, Node o2) {
			if(o1.cnt == o2.cnt) {
				return o1.val-o2.val;
			}else {
				return o1.cnt - o2.cnt;
			}
		}
	}
	static int maxC = 3;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] map = new int[3][3];
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        int goal = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for(int i = 0 ; i < 3 ; i++) {
        	st = new StringTokenizer(br.readLine());
        	//Map<Integer,Integer> map = new HashMap<>();
        	for(int j = 0 ; j < 3 ; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        	     
        }
        
        //map.put(Integer.parseInt(st.nextToken()), map.getOrDefault(Integer.parseInt(st.nextToken()), 0)+1);
        int k = 0;
        while(cnt <= 100) {
        	if(map.length > x && map[0].length > y) {
        		k = map[x][y];
        	}
        	
        	if(k == goal) {
        		break;
        	}
        	if(map.length >= map[0].length) {
        		map = R(map);
        	}else {
        		map = C(map);
        	}
        	cnt++;
//        	for(int i = 0 ; i < map.length ; i++) {
//        		for(int j = 0 ; j < map[i].length ; j++) {
//        			System.out.print(map[i][j]+" ");
//        		}System.out.println();
//        	}System.out.println();
        }
        if(k!=goal) {
        	System.out.println(-1);
        }else {
        	System.out.println(cnt);
        }
    }
    public static int[][] R( int[][] map ) {
    	int max = Integer.MIN_VALUE;
    	List<List<Integer>> list = new ArrayList<>();
    	for(int i = 0 ; i < map.length ; i++) {
    		//list에 넣고 정렬 
    		List<Node> line = new ArrayList<>();
    		Map<Integer,Integer> tmpMap = new HashMap<>();
    		for(int j = 0 ; j < map[i].length ; j++) {
    			if(map[i][j]!=0) {
    				tmpMap.put(map[i][j], tmpMap.getOrDefault(map[i][j],0)+1);
    			}
    		}
    		for(int key : tmpMap.keySet()) {
    			line.add(new Node(key,tmpMap.get(key)));
    		}
    		Collections.sort(line, new NodeCom());
    		List<Integer> inputLine = new ArrayList<>();
    		int size = 0;
    		for(int k = 0 ; k < line.size() ; k++) {
    			inputLine.add(line.get(k).val);
    			inputLine.add(line.get(k).cnt);
    			size+=2;
    		}
    		list.add(inputLine);
    		if(max < size) {
    			max = size;
    		}
    	}
    	int[][] returnMap = new int[list.size()][max];
    	for(int i = 0 ; i < list.size() ; i++) {
    		for(int j = 0 ; j < list.get(i).size() ; j++) {
    			returnMap[i][j] = list.get(i).get(j);
    		}
    	}
    	return returnMap;
    }
    public static int[][] C( int[][] map ) {
    	int max = Integer.MIN_VALUE;
    	List<List<Integer>> list = new ArrayList<>();
    	for(int j = 0 ; j < map[0].length ; j++) {
    		//list에 넣고 정렬 
    		List<Node> line = new ArrayList<>();
    		Map<Integer,Integer> tmpMap = new HashMap<>();
    		for(int i = 0 ; i < map.length ; i++) {
    			if(map[i][j]!=0) {
    				tmpMap.put(map[i][j], tmpMap.getOrDefault(map[i][j],0)+1);
    			}
    		}
    		for(int key : tmpMap.keySet()) {
    			line.add(new Node(key,tmpMap.get(key)));
    		}
    		Collections.sort(line, new NodeCom());
    		List<Integer> inputLine = new ArrayList<>();
    		int size = 0;
    		for(int k = 0 ; k < line.size() ; k++) {
    			inputLine.add(line.get(k).val);
    			inputLine.add(line.get(k).cnt);
    			size+=2;
    		}
    		list.add(inputLine);
    		if(max < size) {
    			max = size;
    		}
    	}
    	int[][] returnMap = new int[max][list.size()];
    	
    	for(int i = 0 ; i < list.size() ; i++) {
    		for(int j = 0 ; j < list.get(i).size() ; j++) {
    			returnMap[j][i] = list.get(i).get(j);
    		}
    	}
    	return returnMap;
    }
    
	   
   
}