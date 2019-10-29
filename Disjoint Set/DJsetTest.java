
public class DJsetTest {
	public static void main(String args[]) {
		DJset dj = new DJset(10);
		dj.makeSet();
		dj.print();
		dj.union(0,1);
		dj.union(1, 2);
		dj.print();
	}
}
