package com.ArraysandStrings;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/?utm_source=chatgpt.com
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Every close bracket has a corresponding open
 * bracket of the same type.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "()"
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s = "()[]{}"
 * 
 * Output: true
 * 
 * Example 3:
 * 
 * Input: s = "(]"
 * 
 * Output: false
 * 
 * Example 4:
 * 
 * Input: s = "([])"
 * 
 * Output: true
 * 
 * Example 5:
 * 
 * Input: s = "([)]"
 * 
 * Output: false
 * 
 * 
 */
public class IsValidParentheses {

	public boolean isValid(String s) {

		char[] paran = s.toCharArray();
		Stack<Character> stk = new Stack<>();
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');

		for (int i = 0; i < paran.length; i++) {
			if (stk.isEmpty() && (paran[i] == ')' || paran[i] == '}' || paran[i] == ']')) {
				return false;
			} else if (paran[i] == '(' || paran[i] == '{' || paran[i] == '[') {
				stk.push(paran[i]);
			} else {
				char top = stk.peek();
				if (paran[i] == map.get(top)) {
					stk.pop();
				} else {
					return false;
				}
			}
		}
		return stk.isEmpty();

	}
	
	public static void main(String[] args) {
		
		IsValidParentheses isValidParentheses = new IsValidParentheses();
		String s1= "()[]{}";
		System.out.println(s1 + " : "+isValidParentheses.isValid(s1));
		String s2= "([])";
		System.out.println(s2 + " : "+isValidParentheses.isValid(s2));
		String s3= "([)]";
		System.out.println(s3 + " : "+isValidParentheses.isValid(s3));
		
	}

}
