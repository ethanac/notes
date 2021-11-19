public class SolutionCountDuplicates {
    /**
     * @param nums: a integer array
     * @return: return an integer denoting the number of non-unique(duplicate) values
     */
    public List<Integer> countduplicates(List<Integer> nums) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.size(); i++) {
            if(map.containsKey(nums.get(i))) {
                if(map.get(nums.get(i)) == -1) {
                    map.put(nums.get(i), i);
                }
            } else {
                map.put(nums.get(i), -1);
            }
        }
    
        List<Integer> result = new ArrayList<>();
        map.forEach((k, v) -> {
            if(v != -1) {
                result.add(k);
            }
        });
        result.sort((e1, e2) -> map.get(e1) - map.get(e2));
        return result;
    }
}