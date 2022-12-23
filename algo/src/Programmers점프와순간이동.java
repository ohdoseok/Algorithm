
import java.util.*;
public class Programmers점프와순간이동 {

	public class Solution {
		public int solution(int n) {
			int ans = 0;
			if(n!=1){
				while(n!=2){
					if((n%2)!=0){
						ans++;
						n--;
					}else{
						n/=2;
					}
				}
			}



			return ++ans;
		}
	}
}
