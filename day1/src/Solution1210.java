import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1210 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String[]> stack = new Stack<>();
		for (int i = 1; i < 11; i++) {
			int point = 0;
			br.readLine();
			for (int j = 0; j < 100; j++) {//100줄을 stack에 저장
				stack.push(br.readLine().split(" "));// 한줄씩 String으로 하나씩 배열저장

			}
			for (int j = 0; j < 100; j++) {//저장된  100줄을 한줄씩 꺼내서 모두 읽는다.
				String[] com = stack.pop();
				if (j==0) {
					for (int k = 0; k < com.length; k++) {
						if (com[k].equals("2")) {
							point = k;
						}
					}

				}else {
					if (point==0) {//0이면 오른쪽을 체크해보고 없으면 올라감
						if (com[point+1].equals("1")) {
							point = go(1,point,com);
						}
					}else if(point==99) {//99면 왼쪽을 체크해보고 없으면 올라감
						if (com[point-1].equals("1")) {
							point = go(0,point,com);
						}
					}else {//왼쪽끝이나 오른쪽 끝이 아니라면
						if (com[point-1].equals("1")) {//왼쪽을 체크해보고 왼쪽으로 가야하면 
							point = go(0,point,com);//왼쪽으로 몇칸 가야하는지 알기위해서 왼쪽으로가라는 0과 현재 위치와 현재 배열을 던져줌 
						}else if (com[point+1].equals("1")) {//오른쪽 
							point = go(1,point,com);
						}

					}




				}

			}
			System.out.printf("#%d %d%n",i,point);
		}
	}

	static int go(int a, int point, String[] arr) {//왼쪽으로 몇칸, 오른쪽으로 몇칸 이동하는지 체크하고 이동한 위치를 return 하는 메소드
		switch (a) {
		case 0://왼쪽
			while(arr[point].equals("1")) {//현재위치에는  1이 있고 왼쪽으로 1이 없어질때 까지 돈다
				if (point==0) {//1이없어진위치가 왼쪽 끝이라면 더이상 왼쪽으로 가지말고 0리턴
					return point;
				}else {
					if (!(arr[point].equals("0"))) {//현재위치가 1이면 
						point--;//현재위치를 왼쪽으로 이동
					}
				}

			}
			point++;
			break;
		case 1://오른쪽
			while(arr[point].equals("1")) {//현재
				if (point==99) {
					return point;
				}else {
					if (!(arr[point].equals("0"))) {
						point++;
					}
				}

			}
			point--;
			break;
		}
		return point;//현재 위치 return
	}
}
