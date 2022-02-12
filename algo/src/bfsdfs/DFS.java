package bfsdfs;



public class DFS {
	static int SIZE;
	static char[] arr;
	static int lastindex;
	DFS(int size){
		this.SIZE = size;
		arr = new char[size+1];
	}
	
	public boolean isEmpty() {
		return lastindex==0;
	}
	public boolean isFull() {
		return lastindex==SIZE;
	}
	public void add(char value) {
		if (isFull()) {
			System.out.println("꽉차서 넣을수가 없어용");
			return;
		}
		lastindex++;
		arr[lastindex] = value;
	}
	public void dfs(int cnt) {
		if (cnt > lastindex) {
			return;
		}
//		System.out.println(arr[cnt]);
		dfs(cnt*2);
//		System.out.println(arr[cnt]);
		dfs(cnt*2+1);
		System.out.println(arr[cnt]);
		
	}
	
}
