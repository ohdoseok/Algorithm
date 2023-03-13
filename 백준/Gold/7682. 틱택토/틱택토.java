import java.util.*;
import java.io.*;


public class Main
{
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//시나리오 
		//X 5, O 4 꽉차서 마무리(X가 빙고이거나 O가 빙고가 아니어야 한다 )
		//X한줄 만들면서 마무리 O는 언제나 X보다 하나적음(O가 빙고이면 안된다)
		//O한줄 만들면서 마무리 X와 O의 갯수는 동일(X가 빙고이면 안된다)
		StringBuilder sb = new StringBuilder();
		String INVALID = "invalid";
		String VALID = "valid";
		String tiktak = br.readLine();
		while(tiktak.length()!=3) {
			
			int cntX = 0;
			int cntO = 0;
			for(int i = 0 ; i < tiktak.length() ; i++) {
				if(tiktak.charAt(i) == 'X') {
					cntX++;
				}else if(tiktak.charAt(i) == 'O') {
					cntO++;
				}
			}
			//1
			if(cntX == 5 && cntO == 4) {
				if(!check(tiktak,'X')&& !check(tiktak,'O')){
					sb.append(VALID+'\n');
				}else if(check(tiktak,'X')&& !check(tiktak,'O')){
					sb.append(VALID+'\n');
				}else {
					sb.append(INVALID+'\n');
				}
				
			}//2
			else if(cntX-1 == cntO) {
				if(check(tiktak,'X')&& !check(tiktak,'O')) {
					sb.append(VALID+'\n');
				}else {
					sb.append(INVALID+'\n');
				}
			}//3
			else if(cntX == cntO) {
				if(check(tiktak, 'O') && !check(tiktak,'X')) {
					sb.append(VALID+'\n');
				}else {
					sb.append(INVALID+'\n');
				}
			}else {
				sb.append(INVALID+'\n');
			}
			tiktak = br.readLine();
			
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
		

	}
	static boolean check(String ori, char check) {
		//가로
		for(int i = 0 ; i < ori.length() ; i+=3){
			if(check == ori.charAt(i)&& check == ori.charAt(i+1)&& check == ori.charAt(i+2)) {
				return true;
			}
		}
		//세로
		for(int i = 0 ; i < 3 ; i++){
			if(check == ori.charAt(i)&& check == ori.charAt(i+3)&& check == ori.charAt(i+6)) {
				return true;
			}
		}
		//대각선
		if(check == ori.charAt(0)&& check == ori.charAt(4)&& check == ori.charAt(8)) {
			return true;
		}
		if(check == ori.charAt(2)&& check == ori.charAt(4)&& check == ori.charAt(6)) {
			return true;
		}
		return false;
	}
}