package com.ArraysandStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/two-sum/?utm_source=chatgpt.com Given an array
 * of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
 * nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2: Input: nums = [3,2,4], target = 6 Output: [1,2]
 * 
 * Example 3: Input: nums = [3,3], target = 6 Output: [0,1]
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {

		// int[] output = new int[2];

		for (int i = 0; i < nums.length; i++) {

			// int temp = target - nums[i];

			for (int j = i + 1; j < nums.length; j++) {
				if (target == nums[i] + nums[j]) {
					// output[0] = i;
					// output[1] =j;
					return new int[] { i, j };
				}
			}

		}

		return new int[] {};

	}

	public int[] twoSum2(int[] nums, int target) {

		HashMap<Integer, Integer> mp = new LinkedHashMap<>();

		for (int i = 0; i < nums.length; i++) {

			mp.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (mp.containsKey(target - nums[i]) && (i != mp.get((target - nums[i])))) {
				return new int[] { i, mp.get((target - nums[i])) };
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {

		TwoSum twoSum = new TwoSum();
		int[] nums = { 3,2,4 };
		int target =6;
		int[] numsout = twoSum.twoSum2(nums, target);
		Arrays.stream(numsout).forEach(x -> System.out.println(x));

	}
}
