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
// Find the largest value on each level for a B tree.
public class SolutionLargestValueBTree {
    /**
     * @param root: a root of integer
     * @return: return a list of integer
     */
    public List<Integer> largestValues(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        Queue<TreeNode> curr = new LinkedList<>();
        curr.offer(root);
        Queue<TreeNode> nextLevel = new LinkedList<>();
        
        while(!curr.isEmpty()) {
            TreeNode node = curr.poll();
            if(node != null) {
                levelList.add(node.val);
                nextLevel.add(node.left);
                nextLevel.add(node.right);
            }
            if(curr.isEmpty()) {
                if(levelList.size() > 0) {
                    Collections.sort(levelList);
                    res.add(levelList.get(levelList.size()-1));
                }
                curr = nextLevel;
                nextLevel = new LinkedList<>();
                levelList = new ArrayList<>();
            }
        }
        if(levelList.size() > 0) {
            Collections.sort(levelList);
            res.add(levelList.get(levelList.size()-1));
        }
        return res;
    }
}