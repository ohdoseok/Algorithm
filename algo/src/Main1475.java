import java.util.*;

public class Main1475 {
	public static void main(String[] args) {
		Map<Character,Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		char[] array = N.toCharArray();
		for(char a : array) {
			if(a=='9'||a=='6') {
				int six = map.getOrDefault('6',0);
				int nine = map.getOrDefault('9',0);
					if(six > nine) {
						map.put('9', map.getOrDefault('9', 0)+1);
					}else {
						map.put('6', map.getOrDefault('6', 0)+1);
					}
				
			}else {
				map.put(a, map.getOrDefault(a, 0)+1);
			}
		}
		List<Integer> list = new ArrayList<>(map.values());
		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list.get(0));
	}
	
}
