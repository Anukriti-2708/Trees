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
    List <Integer> list = new ArrayList<>();
    
    public void Inorder(TreeNode root){
    
        if (root == null ){
            return;
        }
        Inorder (root.left);
        list.add(root.val);
        Inorder(root.right);
    }
    
    public TreeNode getBalanced(List <Integer>list,int start,int end){
        if (start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = getBalanced(list,start,mid-1);
        root.right = getBalanced(list,mid+1,end);
        
        return root;
    }
    
    public TreeNode balanceBST(TreeNode root) {
         if (root == null){
             return null;
         }
        if(root.left == null && root.right == null){
            return root;
        }
         Inorder(root);
         TreeNode node = getBalanced(list,0,list.size()-1);
         root = node;
         return root;
    }
}