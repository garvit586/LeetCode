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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
	    if(root == null){
	        return arr;
	    }
	    Stack<TreeNode> curr = new Stack<>();
	    Stack<TreeNode> next = new Stack<>();
	    
	    boolean child = true;
	    curr.push(root);
	    
	    while(!curr.isEmpty()){
            int n = curr.size();
            List<Integer> arr2 = new ArrayList<>();
            for(int i=0;i<n;i++){
	            TreeNode temp = curr.pop();
	            if(temp != null){
	                arr2.add(temp.val);
	                if(child){
	                    if(temp.left != null){
	                        next.push(temp.left);
	                    }
	                    if(temp.right != null){
	                        next.push(temp.right);
	                    }
	                }else{
	                    if(temp.right != null){
	                        next.push(temp.right);
	                    }
	                    if(temp.left != null){
	                        next.push(temp.left);
	                    }
	                }
	            }
	            if(curr.isEmpty()){
	                Stack<TreeNode> temp2 = curr;
	                curr = next;
	                next = temp2;
	            
	                child = !child;
	            }
            }
            arr.add(arr2);
	    }
	    return arr;
    }
}