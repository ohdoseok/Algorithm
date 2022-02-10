
public class CompleteBinaryTreeTest {
	public static void main(String[] args) {
		CompleteBinaryTree ct = new CompleteBinaryTree(6);
		for (int i = 0; i < 6; i++) {
			ct.add((char)('A'+i));
		}
		ct.bfs();
		
	}
}
