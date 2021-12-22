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
    TreeNode cur = new TreeNode();
   
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        
        TreeNode res = new TreeNode(0);
        cur = res;
        Inorder (root);
        return res.right;
        }
    
    public void Inorder(TreeNode node){
        if(node == null){
            return;
        }
        Inorder(node.left);
        cur.right = node;
        node.left= null;
        cur = node;
        Inorder (node.right);
    }
    
}