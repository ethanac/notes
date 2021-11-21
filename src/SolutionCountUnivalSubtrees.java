package src;

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

public class SolutionCountUnivalSubtrees {
    /**
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    public int countUnivalSubtrees(TreeNode root) {
        // write your code here
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) continue;
            if(search(node, node.val)) {
                count++;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return count;
    }

    private boolean search(TreeNode node, int value) {
        if(node == null) return true;

        if(node.val == value){
            return search(node.left, value) && search(node.right, value);
        }
        return false;   
    }
}