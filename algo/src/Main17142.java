import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17142 {
	static SharkInfo[][] map;
	static SharkInfo[][] mapcp;
	static int R;
	static int C;
	static int M;
	static int[] afterinfo;
	static int rst;
	static public class SharkInfo{
		private int r;
		private int c;
		private int s;//속력
		private int d;//이동방향
		private int z;//크기

		public SharkInfo(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}






	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());//상어수
		map = new SharkInfo[R+1][C+1];
		mapcp = new SharkInfo[R+1][C+1];
		rst = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new SharkInfo(r, c, s, d, z);
		}
		


		for (int k = 1; k < C+1; k++) {
			
			if (k%2==1) {
				for (int i = 1; i < R+1; i++) {
					if (map[i][k]!=null) {
						rst+=map[i][k].z;
						map[i][k]=null;
						break;
					}
				}
				mapcp = new SharkInfo[R+1][C+1];
			}else {
				for (int i = 1; i < R+1; i++) {
					if (mapcp[i][k]!=null) {
						rst+=mapcp[i][k].z;
						mapcp[i][k]=null;
						break;
					}
				}
				map = new SharkInfo[R+1][C+1];
			}
			
			
			
			for (int i = 1; i < map.length; i++) {
				for (int j = 1; j < map[i].length; j++) {
					if (k%2==0) {
						if (mapcp[i][j]!=null) {
							SharkInfo si = mvsharkinfo(mapcp[i][j]);
							if (map[si.r][si.c]!=null) {
								if(map[si.r][si.c].z<si.z) {
									map[si.r][si.c] = si;
								}
							}else {
								map[si.r][si.c] = si;
							}
						}
					}else {
						if (map[i][j]!=null) {
							SharkInfo si = mvsharkinfo(map[i][j]);
							if (mapcp[si.r][si.c]!=null) {
								if(mapcp[si.r][si.c].z<si.z) {
									mapcp[si.r][si.c] = si;
								}
							}else {
								mapcp[si.r][si.c] = si;
							}
						}
					}
				}
			}
			
		}
		System.out.println(rst);

	}

	static SharkInfo mvsharkinfo(SharkInfo si) {
		int r = si.r;
		int c = si.c;
		int s = si.s;
		int d = si.d;
		int z = si.z;
		if (d==1||d==2) {
			s = s % ((R-1) *2);
		}else {
			s = s % ((C - 1)*2);
		}

		afterinfo = new int[3];
		mvshark(s, d, r, c);



		return new SharkInfo(afterinfo[0], afterinfo[1], s, afterinfo[2], z);
	}

	static void mvshark(int s, int d, int r, int c) {
		if (s==0) {
			afterinfo[0] = r;
			afterinfo[1] = c;
			afterinfo[2] = d;
			return;
		}

		switch (d) {
		case 1:
			if (r-1<1) {
				mvshark(s-1,2,r+1,c);
			}else {
				mvshark(s-1,1,r-1,c);
			}
			break;
		case 2:
			if (r+1>R) {
				mvshark(s-1,1,r-1,c);
			}else {
				mvshark(s-1,2,r+1,c);
			}
			break;
		case 3:
			if (c+1>C) {
				mvshark(s-1,4,r,c-1);
			}else {
				mvshark(s-1,3,r,c+1);
			}
			break;
		case 4:
			if (c-1<1) {
				mvshark(s-1,3,r,c+1);
			}else {
				mvshark(s-1,4,r,c-1);
			}
			break;

		default:
			break;
		}


	}

}