
/**
 * Two sums VII
 */
public static class SolutionTwoSummVII {
    /**
		 * nextleft() is to find the next min value.
		 * Starting from min of all, if the value is negative,
		 * check nums[i-1], if nums[i-1] doesn't exist, it means there is no negative numbers, then go from nums[0] to nums[n],
		 * try to find the min positive number.
		 * If the starting value(min of all) is positive, check nums[i+1].
     * @param nums: the input array
     * @param target: the target number
     * @return: return the target pair
     */
    public int nextleft(int left, int[] nums){
        int n = nums.length;
        if (nums[left] < 0){
            for (int i = left - 1; i >= 0; i--)
                if (nums[i] < 0) return i;
            for (int i = 0; i < n; i++)
                if (nums[i] >= 0) return i;
            return -1;
        }
        for (int i = left + 1; i < n; i++)
            if (nums[i] >= 0) return i;
        return -1;
    }

		/**
		 * Same as nextleft()
		 */
    public int nextright(int right, int[] nums){
        int n = nums.length;
        if (nums[right] > 0){
            for (int i = right - 1; i >= 0; i--)
                if (nums[i] > 0) return i;
            for (int i = 0; i < n; i++)
                if (nums[i] <= 0) return i;
            return -1;
        }
        for (int i = right + 1; i < n; i++)
            if (nums[i] <= 0) return i;
        return -1;
    }

		/**
		 * First, go through the array and find out the min value and max value.
		 * Second, use nextleft and nextright to find the min and max value.
		 * Third, compare the sum of min and max with target.
		 */
    public List<List<Integer>> twoSumVII(int[] nums, int target) {
        // write your code here
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (n == 0) return ans;
        int left = 0, right = 0;
        for (int i = 1; i < n; i++){
            if (nums[i] > nums[right]) right = i;
            if (nums[i] < nums[left]) left = i;
        }
        while (nums[left] < nums[right]){
            if (nums[left] + nums[right] < target){
                left = nextleft(left, nums);
                if (left == -1) break;
            }
            else if (nums[left] + nums[right] > target){
                right = nextright(right, nums);
                if (right == -1) break;
            }
            else{
                List<Integer> tmp = new ArrayList<Integer>();
                if (left < right){
                    tmp.add(left); tmp.add(right);
                }
                else{
                    tmp.add(right); tmp.add(left);
                }
                ans.add(tmp);
                left = nextleft(left, nums);
                if (left == -1) break;
            }
        }
        return ans;
    }
}
