import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int val = lcm(arr[0],arr[1]);
        for(int i = 2 ; i < arr.length ; i++){
            val = lcm(val,arr[i]);
        }
        return val;
    }
    public static int lcm(int a, int b){
        
        return (a*b)/gcd(a,b);
    }
        private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}