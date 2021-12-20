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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack <TreeNode> s1 = new Stack<>();
        Stack <TreeNode> s2 = new Stack<>();
         populate (root1, s1);
         populate (root2, s2);
        
        while (!s1.isEmpty() && !s2.isEmpty()){
         TreeNode r1 = s1.peek();
         TreeNode r2 = s2.peek();
        
        if(r1.val > r2.val){
            list.add(r2.val);
            s2.pop();
            populate (r2.right, s2);
        }
            
        else{
            list.add(r1.val);
            s1.pop();
            populate (r1.right, s1);
        }
        }
        
       Stack<TreeNode> s = s1.isEmpty() ? s2 : s1;
        while (!s.isEmpty()) {
            TreeNode r = s.pop();
            list.add(r.val);
            populate(r.right, s);
        }
        return list;
    }
    
    
    public void populate (TreeNode root, Stack s){
        if (root == null){
            return;
        }
        s.push (root);
        populate (root.left,s);
    }
}