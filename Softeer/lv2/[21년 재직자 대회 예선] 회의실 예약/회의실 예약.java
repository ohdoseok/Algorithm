import java.util.*;
import java.io.*;


public class Main
{
    static class Node implements Comparable<Node>{
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Node node){
            if(this.start == node.start){
                return this.end-node.end;
            }else{
                return this.start-node.start;
            }
        }
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, PriorityQueue<Node>> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N ; i++){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            map.put(br.readLine(),pq);
        }
        for(int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            PriorityQueue<Node> pq = map.get(name);
            pq.offer(new Node(start,end));
            map.put(name, pq);
        }
        StringBuilder sb = new StringBuilder();
        List<String> array = new ArrayList<>(map.keySet());
        Collections.sort(array);
        for(String name : array){
            sb.append("Room "+name+":"+'\n');
            List<String> list = new ArrayList<>();
            int start = 9;
            int cnt = 0;
            while(!map.get(name).isEmpty()){
                Node node = map.get(name).poll();
                if(node.start > start){
                    cnt++;
                    if(start==9){
                        list.add("09-"+Integer.toString(node.start));
                    }else{
                        list.add(Integer.toString(start)+"-"+Integer.toString(node.start));
                    }
                }
                start = node.end;
            }
            if(start<18){
                if(start==9){
                    list.add("09-18");
                }else{
                    list.add(Integer.toString(start)+"-18");
                }
                cnt++;
            }
            if(cnt>0){
                sb.append(Integer.toString(cnt)+" available:"+'\n');
                for(int j = 0 ; j < list.size() ; j++){
                    sb.append(list.get(j)+'\n');
                }
            }else{
                sb.append("Not available"+'\n');
            }
            sb.append("-----");
            sb.append('\n');
        }
        String res = sb.substring(0,sb.length()-7);
        System.out.println(res);
    }
}