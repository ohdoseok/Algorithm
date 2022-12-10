import java.util.Comparator;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String val = br.readLine();
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < val.length() ; i++) {
			if(val.charAt(i)=='X') {
				cnt++;
			}else {
				if(cnt!=0) {
					break;
				}else {
					sb.append(val.charAt(i));
				}
			}
			if(cnt == 4) {
				for(int j = 0 ; j < cnt ; j++) {
					sb.append('A');
				}
				cnt = 0;
			}
			if(cnt == 2) {
				if(i+1<val.length() && val.charAt(i+1)!='X') {
					for(int j = 0 ; j < cnt ; j++) {
						sb.append('B');
					}
					cnt = 0;
				}else if(i+1>=val.length()) {
					for(int j = 0 ; j < cnt ; j++) {
						sb.append('B');
					}
					cnt = 0;
				}
			}
		}
		if(cnt != 0){
			System.out.println(-1);
		}else {
			System.out.println(sb.toString());
		}
		
	}
}
