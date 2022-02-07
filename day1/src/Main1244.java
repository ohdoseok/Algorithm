//백준 1244
import java.util.Scanner;

public class Main1244 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int Testcase = sc.nextInt();
		int[] arr = new int[Testcase+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int Testcase2 = sc.nextInt();
		for (int i = 0; i < Testcase2; i++) {
			int it = 1;
			int sex = sc.nextInt();
			int num = sc.nextInt();
			if (sex == 1) {//남자 코드 구현
				int switchcount = Testcase/num;
				for (int j = 1; j < switchcount+1; j++) {
					if (arr[num*j]==1) {
						arr[num*j]=0;
					}else {
						arr[num*j]=1;
					}
				}
			}else {//여자 코드 구현
				if (Testcase==num||num==1) {
					if (arr[num]==0) {
						arr[num]=1;
					}else {
						arr[num]=0;
					}
				}else {
					while(num-it>=1&&num+it<=Testcase) {//범위를 벗어나면
						if (it==1&&arr[num-it]==arr[num+it]) {
							if (arr[num]==1) {
								arr[num]=0;
							}else {
								arr[num]=1;
							}
							if (arr[num-it]==1) {
								arr[num-it]=0;
								arr[num+it]=0;
							}else {
								arr[num-it]=1;
								arr[num+it]=1;
							}
							it++;
						}else if(it==1&&arr[num-it]!=arr[num+it]) {
							if (arr[num]==1) {
								arr[num]=0;
							}else {
								arr[num]=1;
							}
							break;
						}else if(it!=1&&arr[num-it]==arr[num+it]) {
							if (arr[num-it]==1) {
								arr[num-it]=0;
								arr[num+it]=0;
							}else {
								arr[num-it]=1;
								arr[num+it]=1;
							}
							it++;
						}else if(it!=1&&arr[num-it]!=arr[num+it]) {
							break;
						}
					}
				}


			}
		}
		for (int i = 1; i < arr.length; i++) {
			
			if (i==arr.length-1) {
				System.out.printf("%d",arr[i]);
			}else {
				System.out.printf("%d ",arr[i]);
			}
			if (i%20==0) {
				System.out.println();
			}

		}
	}
}
