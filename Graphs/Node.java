import java.util.ArrayDeque;
import java.util.ArrayList;
public class Node {
	int label,preorder,postorder;
	boolean visited;
	ArrayList<Node>adjList;
	Node(int l){
		label = l;
		adjList = new ArrayList<Node>();
	}
	void print() {
		for(int i=0;i<adjList.size();i++) {
			System.out.print(adjList.get(i).label);
			if(i!=adjList.size()-1) System.out.print("->");
		}
		System.out.println();
	}
	int dfs(int count) {
		preorder = count;
		System.out.print(label + " ");
		visited = true;
		for(int i=0;i<adjList.size();i++) {
			if(!adjList.get(i).visited)
				count = adjList.get(i).dfs(++count);
		}
		postorder = ++count;
		return count;
	}
	int isPath(int y,int k) {
		for(int i=0;i<adjList.size();i++) {
			if(adjList.get(i).label == y) k += 1;
			else adjList.get(i).isPath(y,k);
		}
		return k;
	}
	void bfs(ArrayDeque<Node>deq) {
		while(!deq.isEmpty()) {
			Node n = deq.remove();
			System.out.print(n.label + " ");
			for(int i=0;i<n.adjList.size();i++) {
				if(!n.adjList.get(i).visited) {
					n.adjList.get(i).visited = true;
					deq.add(n.adjList.get(i));
				}
			}
		}		
	}
}