import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5607 {
	static int N;
	static int R;
	static int mod = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i < T+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			long[] fac = new long[1000000+1];
			fac[0] = 1;
			for (int j = 1; j < 1000001; j++) {
				fac[j] = (fac[j-1]*j)%mod;
			}
			long NRfac = fac[N-R];
			long Rfac = fac[R];
			
			long left = (fac[N]%mod);
			long right = (long) (powc((NRfac*Rfac)%mod, mod-2)%mod);
			
			
			System.out.println("#"+i+" "+(left*right)%mod);
		}
		
		
		
	}
	
	 static long powc(long num,int p) {
	        if(p==0)
	            return 1;
	        
	        long half = powc(num, p/2);
	        
	        if(p%2==0) {
	            return ((half%mod) * (half%mod))%mod;
	        }else
	            return (((half*num)%mod) * (half%mod))%mod;
	    }
	
	
	
}
