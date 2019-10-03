public class DLLTest {
	public static void main(String[] args) {
		DLL dll = new DLL(10);
		dll.insert(1,20);
		dll.insert(1,30);
		dll.insertAtFirst(40);
		dll.delete(20);
		dll.insert(2, 35);
		dll.deleteAt(2);
		dll.print();
	}
}
