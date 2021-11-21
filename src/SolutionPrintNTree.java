package src;

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * }
 */

public class SolutionPrintNTree {
    /**
     * @param root: the tree root
     * @return: the order level of this tree
     */
    public List<List<Integer>> levelOrder(UndirectedGraphNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(root);
        int countCurrentLevel = 1;
        int countNextLevel = 0;

        while(!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            countCurrentLevel--;
            
            if(node == null) continue;

            tmp.add(node.label); 
            for(UndirectedGraphNode n : node.neighbors) {
                queue.offer(n);
                countNextLevel++;
            }

            if(countCurrentLevel == 0) {
                res.add(tmp);
                tmp = new ArrayList<>();
                countCurrentLevel = countNextLevel;
                countNextLevel = 0;
            }
        }
        if(tmp != null && tmp.size() > 0)
            res.add(tmp);
        return res;
    }
}