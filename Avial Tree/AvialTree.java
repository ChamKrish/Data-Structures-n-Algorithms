import java.util.ArrayDeque;
public class AvialTree {
	protected AVLNode root;
	public void insert(int key) {
		if(root == null) {
			root = new AVLNode(key);
		}
		else root = root.insert(key);
	}
	public void inorder() {
		if(root == null) return;
		else root.inorder();
	}
	public void preorder() {
		if(root == null) return;
		else root.preorder();
	}
	public void postorder() {
		if(root == null) return;
		else root.postorder();
	}
	public boolean search(int key) {
		if(root == null) return false;
		else return root.search(key);
	}
	public void levelorder() {
		ArrayDeque<AVLNode> deq = new ArrayDeque<AVLNode>();
		deq.addLast(root);

		while ( !deq.isEmpty() ) { // until queue is not empty
			AVLNode n = deq.removeFirst();
			System.out.print(n.data + " ");
			if (n.left != null)
				deq.addLast(n.left);
			if (n.right != null)
				deq.addLast(n.right);
		}
		System.out.println();
	}
//	public void delete(int key) {
//		if(root == null) return;
//		else root.delete(key);
//	}
}
