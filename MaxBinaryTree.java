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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        
        if (n == 0){
            return null;
        }
      
       int max = nums[0];
        int idx = 0;
        for(int i = 0;i<n;i++){
            if(nums[i]>max){
                max = nums[i];
                idx = i;
            }
        }
         int [] leftarr = new int[idx];
         for (int i = 0; i<idx;i++){
             leftarr[i]= nums[i];
         }
         int [] rightarr = new int[n-idx-1];
           for (int i =0; i<n-idx-1;i++){
              rightarr[i]= nums[idx+1+i];
               
         }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(leftarr);
        root.right = constructMaximumBinaryTree(rightarr);
        
        return root;
    }
}