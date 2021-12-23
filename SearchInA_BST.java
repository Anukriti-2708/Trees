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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = new TreeNode();
        node = null;
        
        if(root == null){
            return null;
        }
        if (val<root.val){
            node = searchBST(root.left,val);
        }
        if(val == root.val){
            return root;
        }
        if(val>root.val){
            node = searchBST(root.right,val);
        }
        return node;
    }
}