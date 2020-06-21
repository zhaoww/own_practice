package com.zww.problem001;

import java.util.HashMap;
import java.util.Map;

/**
 * @title Solution
 * @description: 两数相加
 * @author: zhaoww
 * @create: 2019/05/09
 */
public class Solution {

    /*
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
    */

    private static int[] a = {2, 7, 11, 15};
    private static int target = 9;

    /**
     * 暴力解法 时间复杂度：O(n^2) 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{
                            i, j
                    };
                }
            }
        }
        return null;
    }

    /**
     * 哈希 时间复杂度：O(n) 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (hash.containsKey(sub) && hash.get(sub) != i) {
                return new int[]{
                        i, hash.get(sub)
                };
            }
        }
        return null;
    }

    /**
     * 哈希 时间复杂度：O(n) 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (hash.containsKey(sub) && hash.get(sub) != i) {
                return new int[]{
                        hash.get(sub), i
                };
            }
            hash.put(nums[i], i);

        }
        return null;
    }

    public static void main(String[] args) {
        int[] ret = twoSum(a, target);
        System.out.println(ret[0] + " " + ret[1]);
    }
}