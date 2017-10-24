

public class DiameterOfBinaryTree {
    
  int max;
  
  public DiameterOfBinaryTree(){
    max = 0;
  }
  
  public int recfun(TreeNode root){
    if(root == null)
      return 0;
    int leftHeight = recfun(root.left);
    int rightHeight = recfun(root.right);
    max = max > leftHeight + rightHeight ? max : leftHeight + rightHeight;
    return 1 + leftHeight > rightHeight ? leftHeight : rightHeight;
  }
  
  public int diameterOfBinaryTree(TreeNode root) {
    recfun(root);
    return max;
  }
  
  
}   
