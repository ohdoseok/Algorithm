import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;



class Top{
	int idx;
	int height;
	public Top(int idx, int height) {
		this.idx = idx;
		this.height = height;
	}
}
public class Main2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int Testcase = Integer.parseInt(sc.readLine());
		Stack<Top> stI = new Stack<>();
		StringTokenizer st = new StringTokenizer(sc.readLine());
		for (int i = 0; i < Testcase; i++) {//Testcase 만큼 탑의 크기를 입력받는다
			int n = Integer.parseInt(st.nextToken());//탑의 크기입력 
			
		
			while(!stI.isEmpty()) {//받은 탑의 크기와 이전에 스택에 쌓여 있던 탑의 크기를 비교해서 신호를 보낼수있는지 확인한다. 만약 스택의 top이 받은 탑의 크기보다 작으면 스택에서 탑의 크기보다 큰 탑을 찾는다.

				if (stI.peek().height>n) {//스택의 top을 확인해서 현재 받은 탑의 크기보다 크면 현재 탑의 신호를 받아줄수있다.
					System.out.print(stI.peek().idx+" ");//신호를 받아준 스택의 top의 탑의 번호를 바로출력
					stI.push(new Top(i+1,n));//현재 탑의 크기를 스택에 현재 번호와 함께 넣어준다
					break;
				}else {//만약 스택의 top이 현재 탑의 크기보다 작다면 현재 탑의 신호를 받아 줄 수 없다. => 현재 탑의 신호를 받아줄 탑을 스택에서 찾아야 한다. => 현재 스택의 top을 제거하고 다음 스택의 탑으로 가서 신호를 받아줄수있는지 확인한다.
					stI.pop();//스택의 top이 신호를 받을 수 없으니 빼버린다.
				}
			}
			if (stI.isEmpty()) {
				System.out.print(0+" ");
				stI.push(new Top(i+1,n));//받은 탑의 크기와 받은 번호를 같이 넣어준다
			}
			
		}

	}
}


