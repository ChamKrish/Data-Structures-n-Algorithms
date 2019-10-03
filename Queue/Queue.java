public class Queue {
	Node head;
	void enqueue(int key) {
		if(head == null) {
			head = new Node(key);
		}
		else {
			Node temp = new Node(key);
			Node curr = head;
			while(curr.next != null) curr = curr.next;
			curr.next = temp;
		}
	}
	
	public int dequeue() throws RuntimeException {
        if ( isEmpty() )
            throw new RuntimeException("Queue is empty");
        else {
            int val = head.data;
            head = head.next;
            return val;
        }
    }
	
	public int front() throws RuntimeException {
        if ( isEmpty() )
            throw new RuntimeException("Queue is empty");
        else
            return head.data;
    }
	
	public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }
	
	public void print() {
		if(isEmpty()) System.out.println("Queue is empty");
		else {
			Node temp = head;
			while(temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
}
