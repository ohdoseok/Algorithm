import java.util.*;
import java.io.*;


public class Main
{
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int[][] like;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        like = new int[(N*N)+1][4];
        List<Integer> order = new ArrayList<>();
        int[] score = {0,1,10,100,1000};
        for(int i = 0 ; i < N*N ; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int idx = Integer.parseInt(st.nextToken());
        	order.add(idx);
        	for(int j = 0 ; j < 4 ; j++) {
        		like[idx][j] = Integer.parseInt(st.nextToken());
        	}
        }
        for(int i = 0 ; i <order.size() ; i++) {
        	int personIdx = order.get(i);
        	List<Node> list = new ArrayList<>();
        	for(int j = 0 ; j < N ; j++) {
        		for(int k = 0 ; k < N ; k++) {
        			if(map[j][k] == 0) {
        				list.add(new Node(j,k));
        			}
        		}
        	}
        	list = one(list, personIdx, map);
        	
        	if(list.size()>1) {
        		list = two(list,map);
        		
        		if(list.size()>1) {
        			list = three(list);
        			Node tmpNode = list.get(0);
        			list = new ArrayList<>();
        			list.add(tmpNode);
        		}
        	}
        	Node node = list.get(0);
        	int x = node.x;
        	int y = node.y;
        	map[x][y] = personIdx;
        	
        }
        int res = 0;
        for(int i = 0 ; i < N ; i++) {
        	for(int j = 0 ; j < N ; j++) {
        		int personIdx = map[i][j];
        		int cnt = 0;
        		for(int k = 0 ; k < 4 ; k++) {
        			if(i+dx[k]<0 || i+dx[k]>=N || j+dy[k]<0 || j+dy[k]>=N) {
        				continue;
        			}
        			int likePerson = map[i+dx[k]][j+dy[k]];
        			for(int z = 0 ; z < 4 ; z++) {
        				if(like[personIdx][z] ==likePerson) {
        					cnt++;
        					break;
        				}
        			}
        		}
        		res+=score[cnt];
        	}
        }
        System.out.println(res);
        
        
    }
    public static List<Node> one(List<Node> list, int personIdx, int[][] map) {
    	int max = Integer.MIN_VALUE;
    	int[][] check = new int[map.length][map.length];
    	boolean[][] ok = new boolean[map.length][map.length];
    	for(int i = 0 ; i < list.size(); i++) {
    		Node node = list.get(i);
    		int x = node.x;
    		int y = node.y;
    		ok[x][y] = true;
    		for(int j = 0 ; j < 4 ; j++) {
    			if(x+dx[j]<0 || x+dx[j]>=map.length || y+dy[j]<0 || y+dy[j]>=map.length) {
    				continue;
    			}
    			for(int k = 0 ; k < 4 ; k++) {
    				if(map[x+dx[j]][y+dy[j]] == like[personIdx][k]) {
    					check[x][y]++;
    				}
    			}
    		}
    		if(max < check[x][y]) {
    			max = check[x][y];
    		}
    	}
    	List<Node> tmplist = new ArrayList<>();
    	for(int i  = 0 ; i < check.length ; i++) {
    		for(int j = 0 ; j < check.length ; j++) {
    			if(ok[i][j] && max == check[i][j]) {
    				tmplist.add(new Node(i,j));
    			}
    		}
    	}
    	return tmplist;
    }
    public static List<Node> two(List<Node> list , int[][] map) {
    	int[][] check = new int[map.length][map.length];
    	boolean[][] ok = new boolean[map.length][map.length];
    	int max = Integer.MIN_VALUE;
    	for(int i = 0 ; i < list.size() ; i++) {
    		Node node = list.get(i);
    		int x = node.x;
    		int y = node.y;
    		ok[x][y] = true;
    		for(int j = 0 ; j < 4 ; j++) {
    			if(x+dx[j]<0 || x+dx[j]>=map.length || y+dy[j]<0 || y+dy[j]>= map.length) {
    				continue;
    			}
    			if(map[x+dx[j]][y+dy[j]] == 0) {
    				check[x][y]++;
    			}
    		}
    		if(max < check[x][y]) {
    			max = check[x][y];
    		}
    	}
    	List<Node> tmplist = new ArrayList<>();
    	for(int i = 0 ; i < check.length ; i++) {
    		for(int j = 0 ; j < check.length ; j++) {
    			if(ok[i][j] && max == check[i][j]) {
    				tmplist.add(new Node(i,j));
    			}
    		}
    	}
    	return tmplist;
    }
    public static List<Node> three(List<Node> list) {
    	Collections.sort(list, new Comparator<Node>(){
    		
    		@Override
    		public int compare(Node o1, Node o2) {
    			if(o1.x == o2.x) {
    				return o1.y - o2.y;
    			}else {
    				return o1.x - o2.x;
    			}
    		}
    	});
    	return list;
    }
}