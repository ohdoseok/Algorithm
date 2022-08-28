import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionSsafy1 {
	public static boolean[] numFishing;
	public static boolean[] visitExit;
	public static int sum;
	public static int[] AExit;
	public static int[] BExit;
	public static int[] CExit;
	public static boolean[] checkVisit;
	public static int tempres;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int N = 1; N < testcase+1; N++) {
			visitExit = new boolean[3];//0 A, 1 B, 2 C
			sum = Integer.MAX_VALUE;
			AExit = new int[2];
			BExit = new int[2];
			CExit = new int[2];
			numFishing = new boolean[Integer.parseInt(br.readLine())];//낚시터 자리 개수 배열로생성
			checkVisit = new boolean[numFishing.length];
			String[] arr = br.readLine().split(" ");//A낚시터 정
			AExit[0] = Integer.parseInt(arr[0])-1;//입구 위치 0부터라서 1뺐
			AExit[1] = Integer.parseInt(arr[1]);//낚시꾼

			arr = br.readLine().split(" ");
			BExit[0] = Integer.parseInt(arr[0])-1;//입구 위치 0부터라서 1뺐
			BExit[1] = Integer.parseInt(arr[1]);//낚시꾼

			arr = br.readLine().split(" ");
			CExit[0] = Integer.parseInt(arr[0])-1;//입구 위치 0부터라서 1뺐
			CExit[1] = Integer.parseInt(arr[1]);//낚시꾼

			dfs(0,0);
			System.out.println("#"+N+" "+sum);



		}
	}
	public static int left(int exit, int person, int dis, int res) {//왼쪽 우선 정렬 
		if (person == 0) {
			return res;
		}
		for (int i = dis; i < numFishing.length; i++) {
			if(exit-i>=0 && !numFishing[exit-i]) {
				numFishing[exit-i] = true;
				checkVisit[exit-i] = true;
				return(left(exit, person-1, i, res+i+1));
			}else if(exit+i<numFishing.length && !numFishing[exit+i]) {
				numFishing[exit+i] = true;
				checkVisit[exit+i] = true;
				return(left(exit, person-1, i, res+i+1));
			}
		}
		return 0;

	}
	public static int right(int exit, int person, int dis, int res) {//오른쪽 우선 정렬
		if (person == 0) {
			return res;
		}
		for (int i = dis; i < numFishing.length; i++) {
			if(exit+i<numFishing.length && !numFishing[exit+i]) {
				numFishing[exit+i] = true;
				checkVisit[exit+i] = true;
				return(right(exit, person-1, i, res+i+1));
				
			}else if(exit-i>=0 && !numFishing[exit-i]) {
				numFishing[exit-i] = true;
				checkVisit[exit-i] = true;
				return(right(exit, person-1, i, res+i+1));
			}
		}
		return 0;
	}
	public static void dfs(int result, int num) {
		if (num == 3) {
			if(sum > result)
				sum = result;
		}
		for (int i = 0; i < 3; i++) {
			if (i==0 && !visitExit[0]) {
				int lV = left(AExit[0], AExit[1], 0, 0);
				boolean[] checkVisit2 = checkVisit.clone();
				for (int j = 0; j < checkVisit.length; j++) {
					checkVisit[j] = false;
				}
				result += lV;
				visitExit[0] = true;
				dfs(result, num+1);
				visitExit[0] = false;
				for (int j = 0; j < checkVisit2.length; j++) {
					if (checkVisit2[j]) {
						numFishing[j] = false;
					}
				}

				result -= lV;

				//왼쪽갔다왔음 


				int rV = right(AExit[0], AExit[1], 0, 0);
				checkVisit2 = checkVisit.clone();
				for (int j = 0; j < checkVisit.length; j++) {
					checkVisit[j] = false;
				}
				result += rV;
				visitExit[0] = true;
				dfs(result, num+1);
				visitExit[0] = false;
				for (int j = 0; j < checkVisit2.length; j++) {
					if (checkVisit2[j]) {
						numFishing[j] = false;
					}
				}
				result -= rV;
			}else if(i==1 && !visitExit[1]) {
				int lV = left(BExit[0], BExit[1], 0, 0);
				boolean[] checkVisit2 = checkVisit.clone();
				for (int j = 0; j < checkVisit.length; j++) {
					checkVisit[j] = false;
				}
				result += lV;
				visitExit[1]=true;
				dfs(result, num+1);
				visitExit[1]=false;
				for (int j = 0; j < checkVisit2.length; j++) {
					if (checkVisit2[j]) {
						numFishing[j] = false;
					}
				}

				result -= lV;

				//왼쪽갔다왔음 


				int rV = right(BExit[0], BExit[1], 0, 0);
				checkVisit2 = checkVisit.clone();
				for (int j = 0; j < checkVisit2.length; j++) {
					checkVisit[j] = false;
				}
				result += rV;
				visitExit[1]=true;
				dfs(result, num+1);
				visitExit[1]=false;
				for (int j = 0; j < checkVisit2.length; j++) {
					if (checkVisit2[j]) {
						numFishing[j] = false;
					}
				}
				result -= rV;

			}else if(i==2 && !visitExit[2]) {
				int lV = left(CExit[0], CExit[1], 0, 0);
				boolean[] checkVisit2 = checkVisit.clone();
				for (int j = 0; j < checkVisit2.length; j++) {
					checkVisit[j] = false;
				}
				result += lV;
				visitExit[2] = true;
				dfs(result, num+1);
				visitExit[2] = false;
				for (int j = 0; j < checkVisit2.length; j++) {
					if (checkVisit2[j]) {
						numFishing[j] = false;
					}
				}

				result -= lV;

				//왼쪽갔다왔음 


				int rV = right(CExit[0], CExit[1], 0, 0);
				checkVisit2 = checkVisit.clone();
				for (int j = 0; j < checkVisit2.length; j++) {
					checkVisit[j] = false;
				}
				result += rV;
				visitExit[2] = true;
				dfs(result, num+1);
				visitExit[2] = false;
				for (int j = 0; j < checkVisit2.length; j++) {
					if (checkVisit2[j]) {
						numFishing[j] = false;
					}
				}
				result -= rV;
			}

		}
	}


}
