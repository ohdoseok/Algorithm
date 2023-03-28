import java.util.*;
import java.io.*;



public class Main
{
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int time = 0 ; time < N ; time++) {
			String fuc = br.readLine();
			int leng = Integer.parseInt(br.readLine());
			String ori = br.readLine();
			String[] array = ori.substring(1,ori.length()-1).split(",");
			int frontIdx = 0;
			int backIdx = array.length-1;
			boolean reverse = false;
			
			for(int i = 0 ; i < fuc.length() ; i++) {
				if(fuc.charAt(i)=='R') {
					reverse = reverse==true?false:true;
				}else {
					if(reverse) {
						backIdx--;
					}else {
						frontIdx++;
					}
				}
				if(frontIdx>backIdx) {
					if(Math.abs(frontIdx-backIdx)>=2) {
						break;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			if(leng==0) {
				if(frontIdx!=backIdx) {
					sb.append("error");
				}else {
					sb.append("[]");
				}
			}else {
				if(frontIdx>backIdx) {
					if(Math.abs(frontIdx-backIdx)>=2) {
						sb.append("error");
					}else {
						sb.append("[]");
					}
				}else {
					sb.append('[');
					if(reverse) {
						for(int idx = backIdx ; idx >= frontIdx ; idx--) {
							sb.append(array[idx]+',');
						}
					}else {
						for(int idx = frontIdx ; idx <= backIdx ; idx++) {
							sb.append(array[idx]+',');
						}
					}
					sb.deleteCharAt(sb.length()-1);
					sb.append(']');
				}
			}
			
			System.out.println(sb.toString());
		}
	}
		
}