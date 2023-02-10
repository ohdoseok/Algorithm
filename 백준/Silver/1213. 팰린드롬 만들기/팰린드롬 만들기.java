import java.io.*;
import java.util.*;
public class Main {
	//전략 : Char Map을 만들어서 홀수가 2개이상이면 I'm Sorry Hansoo 출
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Character,Integer> map = new HashMap<>();
		String val = br.readLine();
		for(int i = 0 ; i < val.length(); i++) {
			char c = val.charAt(i);
			map.put(c, map.getOrDefault(c,0)+1);
		}
		List<Character> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList);
		char centerChar = ' ';
		int odd = 0;
		boolean ok = true;
		for(int i = 0 ; i < keyList.size(); i++) {
			int value = map.get(keyList.get(i));
			int mok = value/2;
			int nam = value%2;
			if(nam!=0) {
				odd++;
				centerChar = keyList.get(i);
			}
			if(odd>1) {
				ok = false;
				break;
			}
			for(int j = 0 ; j < mok ; j++) {
				sb.append(keyList.get(i));
			}
			
		}
		String res = sb.toString();
		if(ok) {
			if(centerChar == ' ') {
				System.out.println(res+sb.reverse().toString());
			}else {
				System.out.println(res+centerChar+sb.reverse().toString());
			}
		}else {
			System.out.println("I'm Sorry Hansoo");
		}
	}
}
