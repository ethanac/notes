/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param s: the s' root
     * @param t: the t' root
     * @return: whether tree t has exactly the same structure and node values with a subtree of s
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // Write your code here
        boolean res = false;

        Queue<TreeNode> queueS = new LinkedList<>();
        queueS.offer(s);

        while(!queueS.isEmpty()) {
            TreeNode nodeS = queueS.poll();

            if(nodeS == null) continue;

            if(nodeS.val == t.val){
                res = compare(nodeS, t);
                if(res)
                    break;
            } 
            queueS.offer(nodeS.left);
            queueS.offer(nodeS.right);
        }

        return res;
    }

    private boolean compare(TreeNode ns, TreeNode nt) {
        if(ns == null && nt == null) return true;

        if(ns == null || nt == null) return false;
        if(ns.val == nt.val) {
            return compare(ns.left, nt.left) && compare(ns.right, nt.right);
        }
        return false;
    }
}