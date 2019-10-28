package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin9496
 * @date 2019/10/28  21:33
 */
public class twoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] arr1 = twoSum1(nums, target);
        int[] arr2 = twoSum2(nums, target);
        for (int i = 0; i < arr1.length; i++){
            System.out.println(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i]);
        }
    }

    /**
     *
     *  暴力解法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return null;
        }
        int[] arr = new int[2];
        for (int i = 0; i < nums.length-1; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    /**
     * Map会更加友好
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int k = target - nums[i];
            if (map.containsKey(k) && map.get(k) != i){
                return new int[]{i, map.get(k)};
            }
        }
        throw new IllegalArgumentException("No two Sum solution");
    }
}
