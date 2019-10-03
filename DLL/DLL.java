public class DLL {
	Node head;
	Node tail;
	DLL(){
		head = null;
		tail = null;
	}
	DLL(int d){
		head = new Node(d);
		tail = head;
	}
	void insertAtFirst(int key) {
		Node temp = new Node(key);
		if(head == null) {
			head = temp;
			tail = head;
		}
		else {
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
	}
	
	void insertAtLast(int key) {
		Node temp = new Node(key);
		if(tail == null) {
			tail = temp;
			head = tail;
		}
		else {
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
	}
	
	void insert(int pos, int key) {
		if(pos == 0) {
			insertAtFirst(key);
		}
		else if(pos > 0 && pos < size()) {
			Node temp = new Node(key);
			Node curr = head;
			for(int i=0;i<pos-1;i++) {
				curr = curr.next;
			}
			temp.next = curr.next;
			curr.next.prev = temp;
			curr.next = temp;
			temp.prev = curr;
		}
		else if(pos == size()) {
			insertAtLast(key);
		}
	}
	
	void deleteAtFirst() {
		Node temp = head;
		head = head.next;
		head.prev = null;
		temp.next = null;
	}
	
	void deleteAtLast() {
		Node temp = tail;
		tail = tail.prev;
		temp.prev = null;
		tail.next = null;
	}
	
	void deleteAt(int pos) {
		if(pos == 0) deleteAtFirst();
		else if(pos == size()-1) deleteAtLast();
		else if(pos > 0 && pos <size()-1) {
			Node temp = head;
			for(int i=0;i<pos;i++) {
				temp = temp.next;
			}
			Node curr = temp.prev;
			curr.next = temp.next;
			temp.next.prev = curr;
			temp.next = null;
			temp.prev = null;
		}
	}
	
	void delete(int key) {
		deleteAt(search(key));
	}
	
	int search(int key) {
		Node temp = head;
		int pos = 0;
		while(temp != null) {
			if(temp.data == key) return pos;
			pos++;
			temp = temp.next;
		}
		return -1;
	}
	
	int size() {
		int count = 0;
		Node temp = head;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	void print() {
		Node curr = head;
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
