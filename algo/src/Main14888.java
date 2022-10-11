import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888 {
	public static int[] numArray;
	public static boolean[] checknumArray;
	public static int[] frArray;
//	public static int[] cpyfrArray;
	public static int max;
	public static int min;
	public static int sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		numArray = new int[num];
		checknumArray = new boolean[num];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		frArray = new int[4];
//		cpyfrArray = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < num; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}
		sum = numArray[0];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			frArray[i] = Integer.parseInt(st.nextToken());
		}
		//cpyfrArray = frArray.clone();
		
		go(1);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void go(int num) {
		if (num == numArray.length) {
			if (max < sum) {
				max = sum;
			}
			if (min > sum) {
				min = sum;
			}
			return;
		}
		for (int i = 1; i < checknumArray.length; i++) {
			if (checknumArray[i]) {
				continue;
			}
			for (int j = 0; j < frArray.length; j++) {
				if (frArray[j]==0) {
					continue;
				}
				if (j==0) {
					int orSum = sum;
					sum+=numArray[i];
					checknumArray[i] = true;
					frArray[j]-=1;
					go(num+1);
					sum = orSum;
					checknumArray[i] = false;
					frArray[j]+=1;
				}else if(j==1) {
					int orSum = sum;
					sum-=numArray[i];
					checknumArray[i] = true;
					frArray[j]-=1;
					go(num+1);
					sum = orSum;
					checknumArray[i] = false;
					frArray[j]+=1;
				}else if(j==2) {
					int orSum = sum;
					sum*=numArray[i];
					checknumArray[i] = true;
					frArray[j]-=1;
					go(num+1);
					sum = orSum;
					checknumArray[i] = false;
					frArray[j]+=1;
				}else {
					int orSum = sum;
					if (sum<0) {
						sum=-(Math.abs(sum)/numArray[i]);
						checknumArray[i] = true;
						frArray[j]-=1;
						go(num+1);
						sum = orSum;
						checknumArray[i] = false;
						frArray[j]+=1;
					}else {
						sum = sum/numArray[i];
						checknumArray[i] = true;
						frArray[j]-=1;
						go(num+1);
						sum = orSum;
						checknumArray[i] = false;
						frArray[j]+=1;
					}
				}
			}
			return;
		}
		
		
	}
	
	
}
