public class AVLNode{
    int data;
    AVLNode left;
    AVLNode right;
    int balanceFactor;
    AVLNode(int d){
        this.data = d;
        balanceFactor = 0;
    }
    public AVLNode insert(int val){
		if(val<data){
			if(left==null){
				left = new AVLNode(val);
			}
			else{
				left = left.insert(val);
			}
		}
		else{
			if(right==null){
				right = new AVLNode(val);
			}
			else{
				right = right.insert(val);
			}
		}
		balanceFactor = computeBalance();
		switch(balanceFactor){
			case 2:
			if(left.balanceFactor>=0){
				return rotateWithleft();
			}
			else{
				left = left.rotateWithRight();
				return rotateWithleft();
			}
			case -2:
			if(right.balanceFactor<=0){
				return rotateWithRight();
			}
			else{
				left = left.rotateWithleft();
				return rotateWithRight();
			}				
			}
			return this;
		}
	public boolean search(int val){
		if(data ==val){
			return true;
		}
		else if(left!=null && val<data){
			return left.search(val);
		}
		else if(right!=null && val>data){
			return right.search(val);
		}
		else{
			return false;
		}
	}

	public AVLNode searchNode(int val){
		if(data == val){
			return this;
		}
		else if(left!=null && val<data){
			return left.searchNode(val);
		}
		else if(right!=null && val>data){
			return right.searchNode(val);
		}
		else{
			return null;
		}
	}
	public void inorder(){
		if(left!=null){
			left.inorder();
		}
		System.out.println(data);
		if(right!=null){
			right.inorder();
		}
	}
	public void postorder(){
		if(left!=null){
			left.postorder();
		}
		if(right!=null){
			right.postorder();
		}
		System.out.println(data);
	}
	public void preorder(){
		System.out.println(data);
		if(left!=null){
			left.preorder();
		}

		if(right!=null){
			right.preorder();
		}
	}
	public boolean isLeaf(){
		if(left==null && right==null){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean hasOnlyLeft(){
		if(left!=null && right==null){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean hasOnlyRight(){
		if(right!=null && left==null){
			return true;
		}
		else{
			return false;
		}
	}
	public int height(){
		if(isLeaf()) {
			return 0;
		}
		else if(hasOnlyLeft()){
			return left.height()+1;
		}
		else if(hasOnlyRight()){
			return right.height()+1;
		}
		else{
			return max(left.height(),right.height()+1);
		}
	}
	public int max(int a, int b){
		if(a>b){
			return a;
		}
		else{
			return b;
		}
	}
	public AVLNode maxNode(){
		if(right==null){
			return this;
		}
		else{
			return right.maxNode();
		}
    }
    public int computeBalance(){
        if(isLeaf()){
            return 0;
        }
        else if(hasOnlyLeft()){
            return (left.height()+1);
		}
		else if(hasOnlyRight()){
			return -1*(right.height()+1);
		}
		else{
			return left.height() - right.height();
		}
    }
    public AVLNode rotateWithleft(){
        AVLNode lc = left;
		left = lc.right;
		lc.right = this;

		computeBalance(); lc.computeBalance();
		return lc;
	}
	public AVLNode rotateWithRight(){
		AVLNode rc = right;
		right = rc.left;
		rc.right = this;
		computeBalance(); rc.computeBalance();
		return rc;
	}

}
