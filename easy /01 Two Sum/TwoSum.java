package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int subtract = target - nums[i];
            if (map.containsKey(subtract)) {
                return new int[]{i, map.get(subtract)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2,7,11,15}, 9);
        Arrays.stream(result).forEach(item -> System.out.print(item + " "));
    }
}
