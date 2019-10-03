public class LinkedList {
	Node head;
	
//	inserting data
	void insert(int d) {
		Node temp = new Node();
		temp.data = d;
		if(head == null)
			head = temp;
		else {
			Node curr = head;
			while(curr.next != null)
				curr = curr.next;
			curr.next = temp;
			
		}
	}
	
//	returns the size of the linkedlist
	int size() {
		Node temp = head;
		int n=0;
		while(temp != null) {
			temp = temp.next;
			n++;
		}
		return n;
	}
	
//	inserting data in specified pos
	void insert(int pos, int key) {
		Node temp = new Node();
		temp.data = key;
		if(pos == 0) {
			temp.next = head;
			head = temp;
		}
		else {
		Node curr = head;
		for(int i=0; i<pos; i++) {
			curr = curr.next;
		}
		temp.next = curr.next;
		curr.next = temp;
		}
	}
	
//	inserting data before a specified key
	void insert_before(int old_key, int new_key) {
		int pos = search(old_key);
		insert(pos-1,new_key);
	}
	
//	inserting data after a specified key
	void insert_after(int old_key, int new_key) {
		int pos = search(old_key);
		insert(pos,new_key);
	}
	
//	printing the linkedlist
	void print() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
//	search a key
	int search(int key) {
		int pos = 0;
		Node temp = head;
		while(temp != null) {
			if(temp.data == key) return pos;
			else 
				{
					temp = temp.next;
					pos++;
				}
		}
		return -1;
	}
	
//	deleting a key
	void delete(int key) {
		int pos = search(key);
		Node curr = head;
		if (pos == 0) {
			head = curr.next;
			curr.next = null;
		}
		else if (pos != -1) {
			for(int i=0;i<pos-1;i++) {
				curr = curr.next;
			}
			Node temp = curr.next;
			curr.next = temp.next;
			temp.next = null;
		}
	}
	
//	middle element of a linkedlist
	int middle_element() {
		Node temp = head;
		int s = size();
		while(search(temp.data) < s/2) {
			temp = temp.next;
		}
		return temp.data;
	}
	
//	Stack implementation with linked list
	
//	pushing a value into stack
	void insertfirst(int key) {
		Node temp = new Node();
		temp.data = key;
		temp.next = head;
		head = temp;
	}
	
//	poping from stack
	void deletefirst() {
		Node temp = head;
		head = head.next;
		temp.next = null;
	}
	
}
