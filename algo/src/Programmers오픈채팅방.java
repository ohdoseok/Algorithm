import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Programmers오픈채팅방 {
	public static void main(String[] args) throws IOException {
		
		class Solution {
		    public String[] solution(String[] record) {
		        
		        Map<String,String> map = new HashMap<>();
		        List<String> list = new ArrayList<>();
		        for(int i = 0 ; i < record.length ; i++){
		            StringTokenizer st = new StringTokenizer(record[i]);
		            String type = st.nextToken();
		            if(type.equals("Leave")){
		                String id = st.nextToken();
		                list.add(id+"님이 나갔습니다.");
		            }else if(type.equals("Enter")){
		                String id = st.nextToken();
		                String nick = st.nextToken();
		                list.add(id+"님이 들어왔습니다.");
		                map.put(id,nick);
		            }else{
		                String id = st.nextToken();
		                String nick = st.nextToken();
		                map.put(id,nick);
		            }
		        }
		        String[] answer = new String[list.size()];
		        for(int i = 0 ; i < list.size() ; i++){
		            String val = list.get(i);
		            int idx = 0;
		            for(int j = 0 ; j < val.length(); j++){
		                if(val.charAt(j)=='님'){
		                    idx = j;
		                    break;
		                }
		            }
		            String id = val.substring(0,idx);
		            String nick = map.get(id);
		            answer[i] = nick+val.substring(idx);
		        }
		        return answer;
		    }
		}
		
	}
	
}
