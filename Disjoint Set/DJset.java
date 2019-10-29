
public class DJset {
	Node[] node;
	int size;
	public DJset(int n) {
		node = new Node[n];
		size = n;
	}
	public void makeSet() {
		for(int i=0;i<size;i++)
			node[i] = new Node(i);
	}
	public Node find(int i) {
		return node[i].getRoot();
	}
	public void print() {
		for(int i=0;i<size;i++)
			System.out.println("(" + i + ":" + find(i).label + ")" + " ");
		System.out.println();
	}
	public void union(int i,int j) {
		Node root1 = find(i);
		Node root2 = find(j);
		if(root1 != root2)
			root2.parent = root1;
	}
}
