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
     * @param root: the root
     * @return: all the values with the highest frequency in any order
     */
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        // Write your code here
        calculate(root);
        int max = Integer.MIN_VALUE;
        for(int k : map.keySet()){
            if(map.get(k) > max) max = map.get(k);
        }
        List<Integer> result = new ArrayList<>();
        for(int k : map.keySet()){
            if(map.get(k) == max) result.add(k);
        }
        int[] arrayResult = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            arrayResult[i] = result.get(i);
        }
        return arrayResult;
    }

    public int calculate(TreeNode node) {
        if(node == null) return 0 ;
        int sum = node.val + calculate(node.left) + calculate(node.right);
        if(map.containsKey(sum)) {
            int value = map.get(sum)+1;
            map.put(sum, value);
        } else {
            map.put(sum, 1);
        }
        return sum;
    }
}