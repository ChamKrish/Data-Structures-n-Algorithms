public class CLLTest {
	public static void main(String[] args) {
		CLL cll = new CLL(25);
		cll.insert(1,20);
		cll.insert(1,30);
		cll.insertAtFirst(40);
		cll.delete(20);
		cll.insert(2,35);
		cll.deleteAt(2);
		cll.print();
	}
}
