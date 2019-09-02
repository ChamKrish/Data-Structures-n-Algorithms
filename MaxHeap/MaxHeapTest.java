import java.util.Random;
public class MaxHeapTest {
	public static void main(String[] args) {
		Random r = new Random();
		int[] keys = new int[10];
		for(int i=0;i<10;i++) {
			keys[i] = r.nextInt(100);
		}
//		int[] keys = {5,3,8,6,2,1,7,9,4,0};
		MaxHeap m = new MaxHeap(keys);
		m.print();
//		System.out.println(m.parent(2));
//		System.out.println(m.get(m.parent(2)));
//		System.out.println(m.parent(0));
//		System.out.println(m.left(1));
//		System.out.println(m.get(m.left(1)));
//		System.out.println(m.left(3));
//		int l = m.left(3);
//		if(l!=-1) System.out.println(m.get(m.left(3)));
//		System.out.println(m.get(8));
		m.buildheap();
		m.print();
		m.check_final();
		System.out.println(m.toString());
	}
}
