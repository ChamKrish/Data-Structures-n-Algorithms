
public class Node {
	int label;
	Node parent;
	public Node(int l) {
		label = l;
	}
	public Node getRoot() {
		if(parent == null) return this;
		else return parent.getRoot();
	}
}
