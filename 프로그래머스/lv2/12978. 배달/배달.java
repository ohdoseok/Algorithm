import java.util.*;
class Solution {
    public static boolean[] check;
    public static int[] array;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N+1][N+1];
        for(int i = 1 ; i < N+1 ; i++){
            for(int j = 1 ; j < N+1 ; j++){
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        check = new boolean[N+1];
        array = new int[N+1];
        check[0] = true;
        for(int i = 2 ; i < array.length ; i++){
            array[i] = Integer.MAX_VALUE;
        }
        for(int i = 0 ; i < road.length ; i++){
            if(map[road[i][0]][road[i][1]] > road[i][2]){
                map[road[i][0]][road[i][1]] = road[i][2];
                map[road[i][1]][road[i][0]] = road[i][2];
            }
        }
        for(int i = 0 ; i < map.length ; i++){
            for(int j = 0 ; j < map.length ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        for(int k = 0 ; k < N ; k++){
            int min = Integer.MAX_VALUE;
            int node = 0;
            for(int i = 1 ; i < array.length ; i++){
                if(!check[i]&&min>array[i]){
                    min = array[i];
                    node = i;
                }
            }
            System.out.println("선택노드"+node);
            check[node] = true;
            for(int i = 1 ; i < map.length ; i++){
                if(check[i] || map[node][i] == Integer.MAX_VALUE){
                    continue;
                }
                if(array[i] > array[node]+map[node][i]){
                    array[i] = array[node]+map[node][i];
                }
            }
        }
        for(int i = 1 ; i < array.length ; i++){
            System.out.println(array[i]);
            if(array[i]<=K){
                answer++;
            }
        }
        return answer;
    }
}