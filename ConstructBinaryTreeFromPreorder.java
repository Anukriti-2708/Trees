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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if(n==0){
            return null;
        }
        
        int r = preorder[0];
        int idx=0;
        TreeNode root = new TreeNode(r);
        if(n==1){
            return root;
        }
        
        
        for (int i=0;i<n;i++){
            if(preorder[i]>r){
                idx = i;
                break;
            }
            }
        
    if (idx!=0){
            int [] left = new int[idx-1];
            for (int i=0;i<idx-1;i++){
               left[i]=preorder[i+1];
            }
            int [] right= new int[n-idx];
                 for (int i=0;i<n-idx;i++){
                     right[i]=preorder[idx+i];
            }
               
            root.left = bstFromPreorder(left);
            root.right = bstFromPreorder(right);
               }
        
        else{
             int [] left = new int[n-1];
             for (int i=0;i<n-1;i++){
             left[i]=preorder[i+1];
            }
            
            root.left = bstFromPreorder(left);
            }
        return root;
        }
    }
