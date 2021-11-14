public class SolutionDiameterOfBTree {
    /**
     * @param root: a root of binary tree
     * @return: return a integer
     */
    int max = 0; //Save current max length
    public int diameterOfBinaryTree(TreeNode root) {
        // write your code here
        maxDepth(root);
        return max;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right); //Compare max and sum of two branches

        return Math.max(left, right) + 1;
    }
}
