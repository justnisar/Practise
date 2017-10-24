class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
  public class BinaryTreeTilt {
  private int result;
  public BinaryTreeTilt(){
    result = 0;
  }
  
  public int recfun(TreeNode root){
    if(root == null)
      return 0;
    int lSum = recfun(root.left);
    int rSum = recfun(root.right);
    result += Math.abs(lSum - rSum);
    return lSum + rSum + root.val;
  }
  
  public int findTilt(TreeNode root) {
     recfun(root);
     return result;
  }
}
