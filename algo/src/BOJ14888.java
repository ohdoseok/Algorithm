import java.util.Scanner;

public class BOJ14888 {
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[] array = new int[4];//덧셈,뺄셈,곱셈,나눗셈
		int[] numA;
		Scanner sc = new Scanner(System.in);
		numA = new int[sc.nextInt()];
		for(int i = 0 ; i < numA .length; i++) {
			numA[i]=sc.nextInt();
		}
		for(int i = 0 ; i < 4; i++) {
			array[i]=sc.nextInt();
		}
		dfs(numA,array,-1,0,0);
	
		System.out.println(max);
		System.out.println(min);
		
	}
	public static void dfs(int[] numA, int[] array, int index, int now, int k) {
		
			if(index==0) {
				now+=numA[k];
			}else if(index ==1) {
				now-=numA[k];
			}else if(index ==2) {
				now*=numA[k];
			}else if(index == 3) {
				now/=numA[k];
			}else {
				now = numA[k];
			}
			if(k==numA.length-1) {
				if(max < now) {
					max = now;
				}
				if(min > now) {
					min = now;
				}
			}
			for(int i = 0 ; i < array.length ; i++) {
				if(array[i]==0) {
					continue;
				}
				array[i]-=1;
				dfs(numA,array,i,now,k+1);
				array[i]+=1;
			}
		
		
	}
}
