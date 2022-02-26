import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2810 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[] arr = new char[T];
		arr = br.readLine().toCharArray();
		boolean check = false;
		int res = 0;
		for (int i = 0; i < T; i++) {
			if (arr[i]=='S') {
				res++;
			}else if(arr[i]=='L') {
				if (!check) {
					res++;
					check = true;
				}else if(check) {
					check=false;
				}
			}
		}
		res++;
		if (res>=T) {
			System.out.println(T);
		}else if(res<T) {
			System.out.println(res);
		}



	}
}
