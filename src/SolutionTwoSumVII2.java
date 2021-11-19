/**
 * Space complexity is not O(1)
 * Time complexity is O(n)
 */
public class SolutionTwoSumVII2 {
  public List<List<Integer>> twoSumVII(int[] nums, int target) {
          // write your code here
          List<List<Integer>> result = new ArrayList<>();

          Map<Integer, Integer> differMap = new HashMap<>();

          for(int i=0; i < nums.length; i++) {
              int differ = target - nums[i];
              if(differMap.containsKey(nums[i])) {
                  List<Integer> r = new ArrayList();
                  r.add(differMap.get(nums[i]));
                  r.add(i);
                  result.add(r);
              }
              differMap.put(differ, i);
          }
          return result;
      }
}
