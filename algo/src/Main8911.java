import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main8911 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0 ; t < N ; t++) {
			int maxY = 0;
			int minY = 0;
			int maxX = 0;
			int minX = 0;
			String s = br.readLine();
			Map<String,Integer> map = new HashMap<>();
			String[][] array = {{"Up","Down"},{"Left","Right"},{"Down","Up"},{"Right","Left"}};
			int idx = 0;
			for(int i = 0 ; i < s.length() ; i++) {
				if(s.charAt(i) == 'F') {
					if(array[idx][0].equals("Down")){
						map.put("Up",map.getOrDefault("Up", 0)-1);
						if(map.get("Up")<0 && minY > map.get("Up")) {
							minY = map.get("Up");
						}
					}else if(array[idx][0].equals("Right")){
						map.put("Left",map.getOrDefault("Left", 0)-1);
						if(map.get("Left")<0 && minX > map.get("Left")) {
							minX = map.get("Left");
						}
					}else {
						map.put(array[idx][0],map.getOrDefault(array[idx][0], 0)+1);
						if(array[idx][0].equals("Up")){
							if(map.get("Up")>0 && maxY < map.get("Up")) {
								maxY = map.get("Up");
							}
						}else {
							if(map.get("Left")>0 && maxX < map.get("Left")) {
								maxX = map.get("Left");
							}
						}
					}
				}else if(s.charAt(i) == 'B') {
					if(array[idx][1].equals("Down")){
						map.put("Up",map.getOrDefault("Up", 0)-1);
						if(map.get("Up")<0 && minY > map.get("Up")) {
							minY = map.get("Up");
						}
					}else if(array[idx][1].equals("Right")){
						map.put("Left",map.getOrDefault("Left", 0)-1);
						if(map.get("Left")<0 && minX > map.get("Left")) {
							minX = map.get("Left");
						}
					}else {
						map.put(array[idx][1],map.getOrDefault(array[idx][1], 0)+1);
						if(array[idx][1].equals("Up")){
							if(map.get("Up")>0 && maxY < map.get("Up")) {
								maxY = map.get("Up");
							}
						}else {
							if(map.get("Left")>0 && maxX < map.get("Left")) {
								maxX = map.get("Left");
							}
						}
					}
				}else if(s.charAt(i) == 'L') {
					idx = (idx+1)%4;
				}else {
					if(idx==0) {
						idx = 3;
					}else {
						idx-=1;
					}
				}
			}
			int x;
			if(maxX == 0 || minX == 0) {
				if(maxX == 0 && minX == 0) {
					x = 0;
				}else {
					if(maxX ==0) {
						x = Math.abs(minX);
					}else {
						x = maxX;
					}
				}
			}else {
				x = maxX+Math.abs(minX);
			}
			int y;
			if(maxY == 0 || minY == 0) {
				if(maxY == 0 && minY == 0) {
					y = 0;
				}else {
					if(maxY ==0) {
						y = Math.abs(minY);
					}else {
						y = maxY;
					}
				}
			}else {
				y = maxY+Math.abs(minY);
			}
			sb.append(x*y);
			sb.append("\n");
		}
		String res = sb.substring(0,sb.length()-1);
		System.out.println(res);

	}
}
