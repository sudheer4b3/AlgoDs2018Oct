package com.array;

public class CoinChange {
	public static void main(String[] args) {
		System.out.println(change(20, new int[]{2,5,10}));
		
		//System.out.println(comboRecursion(5, 0));
	}
	
	private static int change(int amount, int[] coins) {
		int[] combinations = new int[amount+1];
		
		combinations[0] = 1;
		for(int coin:coins) {
			for(int i=1; i<combinations.length;i++) {
				if (i>=coin) {
					combinations[i] += combinations[i-coin];
					print(combinations);
				}
			}
			System.out.println();
		}
		
		return combinations[amount];
	}
	
	private static void print(int arr[]) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int coins[] = {1, 2};
	
	private static int comboRecursion(int amount, int currentCoin) {
		if (amount == 0) {
			return 1;
		}
		if (amount < 0) {
			return 0;
		}
		
		int nCombos = 0;
		for (int coin = currentCoin; coin<coins.length; coin++) {
			nCombos += comboRecursion(amount - coins[coin], coin);
		}
		return nCombos;
	}

}
