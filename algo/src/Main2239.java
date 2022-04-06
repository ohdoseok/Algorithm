import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2239 {
	static int[][] map;
	static String cnt = "";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < map.length; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = arr[j]-'0';
			}
		}

		sqcheck(0, 0);
	}

	static void sqcheck(int i, int j) {
		if (j>=9) {
			i+=1;
			j=0;
			if (i>=9) {
				for (int x = 0; x < 9; x++) {
					for (int y = 0; y < 9; y++) {
						System.out.print(map[x][y]);
					}
					System.out.println();
				}
				System.exit(0);
			}
		}
		if (map[i][j]==0) {
			int Startx = (i/3)*3;
			int Starty = (j/3)*3;

			boolean[] check = new boolean[10];

			for (int k = Startx; k < Startx+3; k++) {
				for (int l = Starty; l < Starty+3; l++) {
					check[map[k][l]] = true;
				}
			}

			for (int k = 1; k < 10; k++) {
				if (!check[k]) {
					if(rowcheck(i,j,k)) {
						map[i][j]=k;
						sqcheck(i, j+1);
						map[i][j]=0;
					}
				}

			}
		}else {
			sqcheck(i, j+1);
		}
		


	}
	static boolean rowcheck(int i, int col, int k) {
		for (int j = 0; j < 9; j++) {
			if(map[i][j]==k) {
				return false;
			}
		}
		if(colcheck(col, k)) {
			return true;
		}else {
			return false;
		}		
	}
	static boolean colcheck(int i, int k) {
		for (int j = 0; j < 9; j++) {
			if(map[j][i]==k) {
				return false;
			}
		}
		return true;
	}




}
