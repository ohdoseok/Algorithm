import java.io.*;
import java.util.*;
public class Main {
	public static int res = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String first = br.readLine();
		String sec = br.readLine();
		while(first.length()!= sec.length()) {
			if(sec.charAt(sec.length()-1)=='A') {
				sec = sec.substring(0,sec.length()-1);
			}else {
				sec = sec.substring(0,sec.length()-1);
				StringBuilder sb = new StringBuilder();
				for(int j = 0 ; j < sec.length() ; j++) {
					sb.append(sec.charAt(j));
				}
				sb.reverse();
				sec = sb.toString();
			}
			
		}
		if(first.equals(sec)) {
			res = 1;
		}
		System.out.println(res);
	}
}
