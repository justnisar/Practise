public class FindDistance {

	public static int bstDistance(int[] values, int n, int node1, int node2) {
		return 0;
	}

	public static Node2 insert(Node2 root, int data) {
		if (root == null)
			return new Node2(data);
		if (root.data > data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}
	
	public static int getHeight(Node2 common,int p){
		Node2 current = common;
		int height1=0;
		while(current != null && current.data!=p){
			if(current.data > p)
				current = current.left;
			else
				current = current.right;
			height1++;
		}
		return height1;
	}
	
	public static int findDistance(Node2 common,int p,int q){
		int height1 = getHeight(common,p);
		int height2 = getHeight(common,q);
		return height1+height2-1;

	}

	public static Node2 lowestCommonAncestor(Node2 root, int p, int q) {
		if (root == null)
			return null;
		if (root.data == p || root.data == q)
			return root;
		Node2 left = lowestCommonAncestor(root.left, p, q);
		Node2 right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null)
			return root;
		if (left != null)
			return left;
		else
			return right;
	}

	public static void printTree(Node2 node){
		if(node == null)
			return;
		printTree(node.left);
		System.out.println(node.data);
		printTree(node.right);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {5,6,3,1,2,4};
		Node2 n = null;
		for (int i : A) {
			n = insert(n, i);
		}
		printTree(n);
		Node2 common = lowestCommonAncestor(n, 2, 4);
		int x = findDistance(common, 2, 4);
		System.out.println(x);
	}


}

class Node2 {
	int data;
	Node2 left;
	Node2 right;

	public Node2(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}