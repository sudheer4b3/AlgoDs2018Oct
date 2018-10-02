package com.mine.trie;

import java.util.HashMap;
import java.util.Map;

//If average length is l and number of words is n then O(ln) is time complexity for insertion
//If average length is l and number of words is n then O(ln) is time complexity for deletion
//If length of word is l then time to search is O(l)

public class TrieNode {
	Map<Character, TrieNode> children;
	boolean endOfWord;
	
	public TrieNode() {
		children = new HashMap<>();
		endOfWord = false;
	}
}
