



public class MinimumAbsoluteDifferenceInBST {
  private int result;
  private TreeNode prev;
  public MinimumAbsoluteDifferenceInBST(){
    result = Integer.MAX_VALUE;
    prev = null;
  }
  
  public void recfun(TreeNode root,TreeNode prev){
    if(root == null)
      return;
    if(prev != null){
      
      result = Math.min(result, Math.abs(root.val - prev.val));
      
    }
    prev = root;
    recfun(root.left,prev);
    recfun(root.right,prev);
  }
  
  public int getMinimumDifference(TreeNode root) {
    printInOrder(root);
    return result;
  }
  
  public void printInOrder(TreeNode root){
    if(root == null)
      return;
    printInOrder(root.left);
    System.out.println(root.val);
    if(prev != null){
      //System.out.println("Difference = " + Math.abs(root.val - prev.val));
      result = Math.min(result, Math.abs(root.val - prev.val));
    }
    prev = root;
    printInOrder(root.right);
  }
  /*
  public static void main(String[] args){
    TreeNode root = new TreeNode(236);
    root.left = new TreeNode(104);
    root.left.right = new TreeNode(227);
    root.right = new TreeNode(701);
    root.right.right = new TreeNode(911);
    MinimumAbsoluteDifferenceInBST obj = new MinimumAbsoluteDifferenceInBST();
    obj.printInOrder(root);
  }
  */
  
}
