import java.util.*;

public class Main2108 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		double sum = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0 ; i < N ; i++) {
			int val = sc.nextInt();
			list.add(val);
			sum+=val;
			map.put(val, map.getOrDefault(val,0)+1);
		}
		Collections.sort(list);
		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<Integer, Integer>>(){
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if(o2.getValue() == o1.getValue()) {
					return o1.getKey() - o2.getKey();
				}else {
					return o2.getValue() - o1.getValue();
				}
				
			}
		});
		int three;
		Map.Entry<Integer, Integer> map1 = entryList.get(0);
		int max = map1.getValue();
		
		if(entryList.size()>1) {
			Map.Entry<Integer, Integer> map2 = entryList.get(1);
			int secmax = map2.getValue();
			if(max == secmax) {
				three = map2.getKey();
			}else {
				three = map1.getKey();
			}
		}else {
			three = map1.getKey();
		}
		
		int first = (int) Math.round(sum/(double)N);
		int sec = list.get(N/2);
		int four = Collections.max(list)-Collections.min(list);
		System.out.println(first);
		System.out.println(sec);
		System.out.println(three);
		System.out.println(four);
	}
}
