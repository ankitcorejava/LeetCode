package com.ArraysandStrings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/?utm_source=chatgpt.com
 * Given a string s, find the length of the longest substring without duplicate
 * characters.
 * 
 * Example 1:
 * 
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the
 * length of 3. Example 2:
 * 
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length
 * of 1. Example 3:
 * 
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the
 * length of 3. Notice that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 */
public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {

		if (s == null || s == "") {
			return 0;
		}
		if (s == " ") {
			return 1;
		}

		HashMap<Character, Integer> frequencyMap = new LinkedHashMap<>();
		HashMap<String, Integer> ans = new LinkedHashMap<>();
		char[] charArrays = s.toCharArray();

		for (int i = 0; i < charArrays.length; i++) {

			if (!frequencyMap.containsKey(charArrays[i]) && (i== charArrays.length-1)) {
				frequencyMap.put(charArrays[i], i);
				Function<Entry<Character, Integer>, String> fun = x -> x.getKey() + "";
				String subStr = frequencyMap.entrySet().stream().map(fun).collect(Collectors.joining());
				ans.put(subStr, subStr.length());
			}

			else if (!frequencyMap.containsKey(charArrays[i])) {
				frequencyMap.put(charArrays[i], i);
			} else {
				Function<Entry<Character, Integer>, String> fun = x -> x.getKey() + "";
				String subStr = frequencyMap.entrySet().stream().map(fun).collect(Collectors.joining());
				ans.put(subStr, subStr.length());
				Set<Entry<Character, Integer>> entry = frequencyMap.entrySet();
				while (entry.iterator().hasNext()) {
					Entry<Character, Integer> itr = entry.iterator().next();
					if (itr.getKey() != charArrays[i]) {
						entry.remove(itr);
					} else {
						break;
					}
				}

				frequencyMap.remove(charArrays[i]);
				frequencyMap.put(charArrays[i], i);
			}

		}

		// ans.entrySet().stream().forEach(x -> System.out.println(x));
		Comparator<? super Entry<String, Integer>> comp = (a, b) -> b.getValue() - a.getValue();

		return ans.isEmpty() == true ? 0 : ans.entrySet().stream().sorted(comp).findFirst().get().getValue();

	}

	public static void main(String[] args) {

		LengthOfLongestSubstring len = new LengthOfLongestSubstring();
		System.out.println(" " + " : " + len.lengthOfLongestSubstring(" "));
		System.out.println("abcabcbb : " + len.lengthOfLongestSubstring("abcabcbb"));
		System.out.println("bbbbb : " + len.lengthOfLongestSubstring("bbbbb"));
		System.out.println("pwwkew : " + len.lengthOfLongestSubstring("pwwkew"));
		System.out.println("" + " : " + len.lengthOfLongestSubstring(""));

	}

}
