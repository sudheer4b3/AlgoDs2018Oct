package com.mine.trie;

/*
 * Insert and search costs O(key_length), 
 * however the memory requirements of Trie is O(ALPHABET_SIZE * key_length * N) 
 * where N is number of keys in Trie. 
 * There are efficient representation of trie nodes 
 * (e.g. compressed trie, ternary search tree, etc.) to minimize memory requirements of trie.
 * */
public class TrieOperations {
	private final TrieNode root;
	
	public TrieOperations() {
		root = new TrieNode();
	}
	
	//Iterative implementation of insert
	public void insert(String word) {
		TrieNode current = root;
		for (int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}
	
	//Recursive implementation of insert
	public void insertRecursive(String word) {
		insertRecursive(root, word, 0);
	}
	
	private void insertRecursive(TrieNode current, String word, int index) {
		if(index == word.length()) {
			current.endOfWord = true;
			return;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		
		if (node == null) {
			node = new TrieNode();
			current.children.put(ch, node);
		}
		insertRecursive(node, word, index + 1);
	}
	
	//Iterative implementation of search
	public boolean search(String word) {
		TrieNode current = root;
		for (int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.endOfWord;
	}
	
	public void delete(String word) {
		delete(root, word, 0);
	}
	
	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			//when end of word is reached, only delete if current.endOfWord is true.
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			return current.children.size() == 0;
		}
		
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}
		
		boolean shouldDeleteCurrentNode = delete(node, word, index+1);
		
		if(shouldDeleteCurrentNode) {
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}

}
