import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074 {
	static int N;
	static int sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int line = (int)Math.pow(2, N);
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		go(line,x,y);
		System.out.println(sum);
	}
	static void go(int line, int x, int y) {
		if (line==1) {
			return;
		}
		if (x<line/2&&y<line/2) {
			//1분면
			go(line/2,x,y);
		}else if(x>=line/2&&y<line/2) {
			sum+=line*line/2;
			go(line/2,x-line/2,y);
			//3분면
		}else if(x<line/2&&y>=line/2) {
			sum+=line*line/4;
			go(line/2,x,y-line/2);
			//2분면
		}else {
			sum+=line*line/4*3;
			go(line/2,x-line/2,y-line/2);
			//4분면
		}
		
		
	}

} 