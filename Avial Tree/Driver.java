public class Driver {
	public static void main(String[] args) {
		AvialTree b=new AvialTree();
		b.insert(15);
		b.insert(20);
		b.insert(24);
		b.insert(10);
		b.insert(13);
		b.insert(7);
		b.insert(30);
		b.insert(36);
		b.insert(25);
		b.levelorder();
		b.inorder();
		b.preorder();
	}
}