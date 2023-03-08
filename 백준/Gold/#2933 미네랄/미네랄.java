import java.util.*;
import java.io.*;


public class Main
{
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for(int i = 0 ; i < N ; i++) {
        	String val = br.readLine();
        	for(int j = 0 ; j < M ; j++) {
        		map[i][j] = val.charAt(j);
        	}
        }
        
        int arrayLength = Integer.parseInt(br.readLine());
        int[] throwArray = new int[arrayLength];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arrayLength ; i++) {
        	throwArray[i] = Math.abs(Integer.parseInt(st.nextToken())-N);
        	//왼쪽 에서 던지는 경우 
        	if(i % 2 ==0) {
        		leftThrow(map,throwArray[i]);
        	}else {
        		//오른쪽에서 던지는 경우 
        		rightThrow(map,throwArray[i]);
        	}
//        	for(int k = 0 ; k < map.length ; k++) {
//            	for(int j = 0 ; j < map[k].length ; j++) {
//            		System.out.print(map[k][j]);
//            	}
//            	System.out.println();
//            }
//        	System.out.println();
        }
        for(int i = 0 ; i < map.length ; i++) {
        	for(int j = 0 ; j < map[i].length ; j++) {
        		System.out.print(map[i][j]);
        	}
        	System.out.println();
        }
    }
    //왼쪽에서 던지는 코드 
    public static void leftThrow(char[][] map , int high) {
    	for(int i = 0 ; i < map[high].length ; i++) {
    		if(map[high][i] == 'x') {
    			map[high][i] = '.';
    			break;
    		}
    	}
    	topDown(map);
    }
    //오른쪽에서 던지는 코드 
   public static void rightThrow(char[][] map , int high) {
	   for(int i = map[high].length-1 ; i >= 0 ; i--) {
	   		if(map[high][i] == 'x') {
	   			map[high][i] = '.';
	   			break;
	   		}
	   	}
	   	topDown(map);
   }
   //위에서 내려와서 클러스터 덩어리를 찾는 코 드 
   public static void topDown(char[][] map) {
	   
	   
	   //각 열마다행이 가장 큰 값을 넣었다면 각 열에서 행과 x나 배열이 넘어가는 경우를 찾는다.
	   Queue<Node> q = new LinkedList<>();
	   boolean[][] visitAll = new boolean[map.length][map[0].length];
	   char[][] tmpMap = new char[map.length][map[0].length];
	   for(int i = 0 ; i < map.length ; i++) {
		   for(int j = 0 ; j < map[i].length ; j++) {
			   tmpMap[i][j] = map[i][j];
		   }
	   }
	   for(int i = 0 ; i < map.length ; i++) {
		   for(int j = 0 ; j < map[i].length ; j++) {
			   if(!visitAll[i][j] && map[i][j] == 'x') {
				 //클러스터내의 모든 node값을 기록하기 위한 list
				   List<Node> list = new ArrayList<>();
				   q.offer(new Node(i,j));
				   boolean[][] visit = new boolean[map.length][map[0].length];
				   visit[i][j] = true;
				   visitAll[i][j] = true;
				   list.add(new Node(i,j));
				   while(!q.isEmpty()) {
					   Node node = q.poll();
					   int x = node.x;
					   int y = node.y;
					   for(int k = 0 ; k < 4 ; k++) {
						   if(x+dx[k]<0 || x+dx[k]>=map.length || y+dy[k]<0 || y+dy[k]>=map[0].length || visit[x+dx[k]][y+dy[k]] ) {
							   continue;
						   }
						   if(map[x+dx[k]][y+dy[k]]=='x') {
							   q.offer(new Node(x+dx[k],y+dy[k]));
							   list.add(new Node(x+dx[k],y+dy[k]));
							   visit[x+dx[k]][y+dy[k]] = true;
							   visitAll[x+dx[k]][y+dy[k]] = true;
						   }
					   }
				   }
				   //이제 바닥과 가장가까운 행들과 가장 가까운게 바닥인지 다른 클러스터인지 찾아야함.
				  changeCluster(list,map,tmpMap, visit);
			   }
		   }
	   }
	   for(int i = 0 ; i < map.length ; i++) {
		   for(int j = 0 ; j < map[i].length ; j++) {
			   map[i][j] = tmpMap[i][j];
		   }
	   }
   }
   //바닥과 가장 가까운 행들과 가장 가까운게 바닥인지 다른 클러스터인지 찾고 내려주는 코드 
   //바닥과 가장 가까운건 안된다. 그냥 각 클러스터를 모두 조사해서 다른클러스터나 바닥에 닿는걸로 변경 
   public static void changeCluster(List<Node> list , char[][]map,char[][]tmpMap, boolean[][] visit) {
//	   for(Node node : list) {
//		   System.out.println(node.x+":"+node.y);
//	   }
//	   System.out.println("");
	   int min = Integer.MAX_VALUE;
	  for(int k = 0 ; k < list.size() ; k++) {
		  //1이 제일 가까운경우 
		  if(min == 1) {
			  break;
		  }
		  Node node = list.get(k);
		  int x = node.x;
		  //바닥과 만나는 경우 
		  if(min > map.length-x) {
			  min = map.length-x;
		  }
		  int y = node.y;
		  for(int i = x+1 ; i < map.length ; i++) {
			  //다른클러스터를 만나는 경우 
			  if(!visit[i][y] && map[i][y] == 'x') {
				  if(min > i-x) {
					  min = i-x;
					  break;
				  }
			  }
		  }
	  }
	  min -=1;
	  boolean[][] ok = new boolean[map.length][map[0].length];
	  if(min != 0) {
		  for(int i = 0 ; i < list.size() ; i++) {
			  Node node = list.get(i);
			  int x = node.x;
			  int y = node.y;
			  tmpMap[x+min][y] = 'x';
			  ok[x+min][y] = true;
		  }
		  for(int i = 0 ; i < list.size() ; i++) {
			  Node node = list.get(i);
			  int x = node.x;
			  int y = node.y;
			  if(!ok[x][y]) {
				  tmpMap[x][y] = '.';
			  }
			 
		  }
	  }
   }
}