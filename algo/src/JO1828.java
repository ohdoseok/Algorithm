import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.swing.text.Highlighter.Highlight;

public class JO1828 {
	static class rf implements Comparable<rf>{
		int low;
		int high;
		rf(int low,int high){
			this.low = low;
			this.high = high;
		}

		@Override
		public String toString() {
			return "rf [low=" + low + ", high=" + high + "]";
		}

		@Override
		public int compareTo(rf o) {

			return this.low==o.low?this.high-o.high:this.low-o.low;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<rf> q = new PriorityQueue<>();
		int lownum = 0;
		int highnum = 0;
		int res = 0;
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			rf r = new rf(low,high);

			q.offer(r);
		}
		for (int i = 0; i < T; i++) {
			rf r = q.poll();
			if (i==0) {
				lownum = r.low;
				highnum = r.high;
			}else {
				if (r.low>=lownum&&r.low<=highnum) {
					if (r.high<=highnum) {
						lownum = r.low;
						highnum = r.high;
					}else {
						lownum = r.low;
					}
				}else{
					res++;
					lownum = r.low;
					highnum = r.high;
				}
			}
		}
		res++;//마지막에 빠질때 1개 추가
		System.out.println(res);
	}
}
