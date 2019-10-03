
public class Stack {
	Node head;
	void push(int key) {
//	Inserting at head - insertAtFirst
		if(head == null) {
			head = new Node(key);
		}
		else {
			Node temp = new Node(key);
			temp.next = head;
			head = temp;
		}
	}
//	deleting at head - deleteAtFirst
	int pop() {
		if(isEmpty()) return Integer.MAX_VALUE;
		else {
			int x = head.data;
			head = head.next;
			return x;
		}
	}
	int peek() {
		if(head == null) {
			System.out.println("Stack is empty");
			return Integer.MAX_VALUE;
		}
		else return head.data;
		
	}
	
//	public int pop() throws RuntimeException {
//        if ( isEmpty() )
//            throw new RuntimeException("Queue is empty");
//        else {
//            int val = head.data;
//            head = head.next;
//            return val;
//        }
//    }
//	
//	public int peek() throws RuntimeException {
//        if ( isEmpty() )
//            throw new RuntimeException("Queue is empty");
//        else
//            return head.data;
//    }
	
	boolean isEmpty() {
		if(head == null) return true;
		else return false;
	}
	void print() {
		Node temp = head;
		if(isEmpty()) System.out.println("Stack is empty");
		else {
			while(temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
}
