import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int[] numarr = new int[6];
		int[] valuearr = new int[6];
		int[] farr = new int[5];
		int diff = 0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			numarr[i] = num;
			valuearr[i] = value;
			farr[num] = value;
		}
		for (int i = 0; i < 6; i++) {
			if (numarr[i]==4&&numarr[(i+1)%6]==1) {
				diff = valuearr[i]*valuearr[(i+1)%6];
				break;
			}else if(numarr[i]==1&&numarr[(i+1)%6]==3) {
				diff = valuearr[i]*valuearr[(i+1)%6];
				break;
			}else if(numarr[i]==3&&numarr[(i+1)%6]==2) {
				diff = valuearr[i]*valuearr[(i+1)%6];
				break;
			}else if(numarr[i]==2&&numarr[(i+1)%6]==4) {
				diff = valuearr[i]*valuearr[(i+1)%6];
				break;
			}
		}
		int res = Math.max(farr[1], farr[2])*Math.max(farr[3], farr[4])-diff;
		System.out.println(res*V);
	}
}
