package com.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
	
	public static int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] args) {
		int[] nums = new int[5];
		nums[0] = 3; nums[1] = 4; nums[2] = 2; nums[3] = 7; nums[4] = 8;
		int[] res = twoSum(nums, 9);
		System.out.println(res[0] +" "+res[1]);
	}

}
