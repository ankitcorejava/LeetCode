package com.ArraysandStrings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/?utm_source=chatgpt.com
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1], k = 2 Output: 2 Example 2:
 * 
 * Input: nums = [1,2,3], k = 3 Output: 2
 */
public class SubarraySum {

	public int subarraySum(int[] nums, int k) {

		int ans = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(sum, 1);

		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (map.containsKey(sum - k)) {
				ans = ans + map.get(sum-k);
			}
			//map.put(sum, map.getOrDefault(sum, 0 )+ 1);
			if(map.containsKey(sum)) {
				map.put(sum, map.get(sum)+1);
			}
			else {
				map.put(sum,1);
			}
			
			
			
		}

		return ans;

	}

	public int subarraySum2(int[] nums, int k) {

		int outputCnt = 0;

		for (int i = 0; i < nums.length; i++) {

			int sum = nums[i];
			if (sum == k) {
				outputCnt++;
			}
			for (int j = i + 1; j < nums.length; j++) {

				sum = sum + nums[j];
				if (sum == k) {
					outputCnt++;
				} else {
					continue;
				}

			}
		}
		return outputCnt;

	}

	public static void main(String[] args) {

		SubarraySum sub = new SubarraySum();
		int[] nums = { 1, 1, 1 };
		int k = 2;
		System.out.println(sub.subarraySum(nums, k));
		int[] nums1 = { 28, 54, 7, -70, 22, 65, -6 };
		int k1 = 100;
		System.out.println(sub.subarraySum(nums1, k1));
	}

}
