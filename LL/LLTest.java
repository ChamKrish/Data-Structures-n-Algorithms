
public class LLTest {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert(5);
		l.insert(11);
		l.insert(20);
		l.insert(7);
		l.insert(25);
		l.print();
		System.out.println(l.search(7));
		l.insert(3,45);
		l.delete(25);
		l.print();
		System.out.println(l.middle_element());
	}
}
