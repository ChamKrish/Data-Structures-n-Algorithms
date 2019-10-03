import java.util.ArrayDeque;
public class Graph {
	Node[] node;
	int size;
	Graph(int n){
		size = n;
		node = new Node[n];
		for(int i=0;i<n;i++)
			node[i] = new Node(i);
	}
	void addEdge(int from,int to) {
		node[from].adjList.add(node[to]);
	}
	void print() {
		for(int i=0;i<size;i++) {
			System.out.print(i + ":");
			node[i].print();
		}
	}
	void dfs() {
		int count = 0;
		for(int i=0;i<size;i++) {
			if(!node[i].visited)
				count = node[i].dfs(++count);
		}
		System.out.println();
	}
	void bfs() {
		ArrayDeque<Node>deq = new ArrayDeque<Node>();
		for(int i=0;i<size;i++) {
			if(!node[i].visited) {
				deq.addLast(node[i]);
				node[i].visited = true;
				node[i].bfs(deq);
			}
		}
		System.out.println();
	}
	int isPath(int x,int y) {
		return node[x].isPath(y,0);
	}
	void printOrder() {
		for(int i=0;i<size;i++) {
			System.out.print(node[i].label+"-"+node[i].preorder+"/"+node[i].postorder+"   ");
		}
		System.out.println();
	}
}
