package LeetCode.Arrays;
import java.util.HashMap;
public class TwoSum {
    class Solution1 { // O(n^2) solution
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            int n = nums.length;
            for(int i=0; i < n-1; i++){
                for(int j=i+1; j<n; j++){
                        if(nums[i] + nums[j] == target){
                            result[0] = i;
                            result[1] = j;
                            return result;
                        }
                }
            }
            return null;
        }
    }


    class Solution2 { // O(n) solution
        public int[] twoSum(int[] nums, int target) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                int needed = target - nums[i];

                if (map.containsKey(needed)) {
                    return new int[]{map.get(needed), i};
                }

                map.put(nums[i], i);
            }

            return null;
        }
    }

}
