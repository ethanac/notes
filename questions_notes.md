## Questions
1. 给定一个已经按绝对值升序排列的数组，找到两个数使他们加起来的和等于特定数。
函数应该返回这两个数的下标，index1必须小于index2。注意：数组的下标以0开始。
你不能对该数组进行排序。
挑战
O(n)的时间复杂度 和 O(1)的额外空间复杂度

Solution:
Two pointer
left 指向最小值，right 指向最大值。两指针分别移动，求和判断即可。

public class Solution {
    /**
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