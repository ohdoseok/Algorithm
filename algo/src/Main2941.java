import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		int res = 0;
		for (int i = 0; i < text.length(); i++) {
			char nc = ' ';
			char nnc = ' ';
			char c = text.charAt(i);
			if(i+1<text.length()) {
				nc = text.charAt(i+1);
			}
			if (i+2<text.length()) {
				nnc = text.charAt(i+2);
			}
			if (c=='c'&&nc=='='||c=='c'&&nc=='-'||c=='d'&&nc=='-'||c=='l'&&nc=='j'||c=='n'&&nc=='j'||c=='s'&&nc=='='||c=='z'&&nc=='=') {
				i++;
			}
			if(c=='d'&&nc=='z'&&nnc=='=') {
				i=i+2;
			}
			res++;
		}
		System.out.println(res);
		
	}
}
