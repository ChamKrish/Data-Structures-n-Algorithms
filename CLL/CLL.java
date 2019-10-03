public class CLL {
	Node head;
	Node tail;
	CLL(){
		head = null;
		tail = null;
	}
	CLL(int d){
		head = new Node(d);
		tail = head;
		tail.next = head;
	}
	void insertAtFirst(int key) {
		Node temp = new Node(key);
		if(head == null) {
			head = temp;
			tail = head;
			tail.next = head;
		}
		else {
			temp.next = head;
			head = temp;
			tail.next = head;
		}
	}
		
	void insertAtLast(int key) {
		Node temp = new Node(key);
		if(tail == null) {
			tail = temp;
			head = tail;
			tail.next = head;
		}
		else {
			tail.next = temp;
			tail = temp;
			tail.next = head;
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
			curr.next = temp;
		}
		else if(pos == size()) {
			insertAtLast(key);
		}
	}
	
	void deleteAtFirst() {
		Node temp = head;
		head = head.next;
		tail.next = head;
		temp.next = null;
	}
	
	void deleteAtLast() {
		Node curr = head;
		for(int i=0;i<size()-2;i++) {
			curr = curr.next;
		}
		tail.next = null;
		tail = curr;
		tail.next = head;
	}
	
	void deleteAt(int pos) {
		if(pos == 0) deleteAtFirst();
		else if(pos == size()-1) deleteAtLast();
		else if(pos > 0 && pos <size()-1) {
			Node temp = head;
			for(int i=0;i<pos-1;i++) {
				temp = temp.next;
			}
			Node curr = temp.next;
			temp.next = curr.next;
			curr.next = null;
		}
	}
	
	void delete(int key) {
		deleteAt(search(key));
//		System.out.println(search(key));
	}
	
	int search(int key) {
		Node temp = head;
		int pos = 0;
		do {
			if(temp.data == key) {
				return pos;
			}
			pos++;
			temp = temp.next;
		}while(temp != head);
		return -1;
	}
	
	int size() {
		int count = 0;
		Node temp = head;
		do {
			count++;
			temp = temp.next;
		}while(temp != head);
		return count;
	}
	
	void print() {
		Node curr = head;
		if(curr != null) System.out.println(curr.data);
		curr = curr.next;
		while(curr != head) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
