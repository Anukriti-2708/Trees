/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
     TreeNode temp = new TreeNode();
        if (root1 == null && root2 == null){
            return null;
        }
        
        
       else if(root1!=null && root2!=null){
        temp.val = root1.val + root2.val;
        }
        else if (root1==null){
        temp.val = root2.val;
             temp.left =  mergeTrees(null,root2.left);
       temp.right =  mergeTrees(null,root2.right);
            return temp;
        }
        else if(root2==null){
        temp.val = root1.val;
             temp.left =  mergeTrees(root1.left,null);
       temp.right =  mergeTrees(root1.right,null);
            return temp;
        }
         
       temp.left =  mergeTrees(root1.left,root2.left);
       temp.right =  mergeTrees(root1.right,root2.right);
        
        return temp;
    }
}