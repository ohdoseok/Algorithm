import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main1755 {

	public static class Node implements Comparable<Node>{//들어오는 숫자와 숫자에 따른 가중치를 넣어줄 class
		private int num;//들어가는 수
		private int val;//가중치

		public Node(int num, int val) {
			super();
			this.num = num;
			this.val = val;
		}

		@Override
		public int compareTo(Node node) {//가중치가 낮은 순서부터 정렬
			// TODO Auto-generated method stub
			return this.val-node.val;
		}


	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());//첫번째수
		int end = Integer.parseInt(st.nextToken());//마지막수
		int[] value = {10,5,9,8,3,2,7,6,1,4};//0~9까지의 수의 가중치값
		List<Node> list = new ArrayList<>();//정렬할 리스트
		for (int i = start; i < end+1; i++) {//처음 부터 끝까지 돌면서 가중치를 넣어서 리스트 생성
			int mok = i/10;
			int nam = i%10;
			if (mok==0) {//몫이 0이면 한자리 숫자라서 가중치를 따로 
				list.add(new Node(i, value[nam]*10));
			}else {
				list.add(new Node(i, value[mok]*10+value[nam]-1));//십의 자리수의 가중치를 우선으로두고 그다음 비교를 위해 1의자리수 가중치를 더함 -1은 ex)2와 30의 경우처럼 가중치가 80,80으로 동일하게 나올경우 3의 가중치를 더 낮추기위함
			}
		}
		Collections.sort(list);//가중치에 따라 정렬
		for (int i = 0; i < list.size(); i++) {//모든 리스트를 돌면서 가중치가 낮은 순서대로 출력

			if (i==list.size()-1) {//마지막일 경우 공백,줄바꿈 없이 값 출력
				System.out.printf("%d",list.get(i).num);
				
			}else {
				if (i%10==9) {//10번째마다 출력하고 줄바꿈
					System.out.printf("%d",list.get(i).num);
					System.out.println();
				}else {
					System.out.printf("%d ",list.get(i).num);
				}
			}
			
		}
	}
}
