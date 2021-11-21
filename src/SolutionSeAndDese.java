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

public class SolutionSeAndDese {
    /**
     * @param data: a string after a tree serializing
     * @return: the tree after a string deserialization
     */
    public String serialize(TreeNode root) {
        String res = "";
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) 
                res += "#";
            else {
                res += node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }
            res += ",";
        }
        return res.substring(0, res.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] strArray = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;

        while(i < strArray.length) {
            TreeNode curr = queue.poll();
            if("#".equals(strArray[i]))
                curr.left = null;
            else {
                curr.left = new TreeNode(Integer.parseInt(strArray[i]));
                queue.offer(curr.left);
            }
            i++;
            if("#".equals(strArray[i]))
                curr.right = null;
            else {
                curr.right = new TreeNode(Integer.parseInt(strArray[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}