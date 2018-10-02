package com.mine.others;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		int numbers[] = {0, 2, 7, 11, 15};
		int[] result = twoSum(9, numbers);
		System.out.println(result[0]+" : "+result[1]);
		
		result = twoSum(numbers, 9);
		System.out.println(result[0]+" : "+result[1]);
	}
	
	public static int[] twoSum(int target, int[] numbers) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
		    if (map.containsKey(numbers[i])) {
		        return new int[]{map.get(numbers[i]) + 1, i + 1};
		    } else {
		        map.put(target - numbers[i], i);
		    }
		}
		return new int[]{0, 0};
	}
}

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */