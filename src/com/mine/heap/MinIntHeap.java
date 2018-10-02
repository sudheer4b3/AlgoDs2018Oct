package com.mine.heap;

import java.util.Arrays;

public class MinIntHeap {
	private int capacity = 10;
	private int size = 0;
	
	int[] items = new int[capacity];
	
	private int getLeftChildIndex(int index) {
		return (2*index + 1);
	}
	
	private int getRightChildIndex(int index) {
		return (2*index + 2);
	}
	
	private int getParentIndex(int index) {
		return (index - 2)/2;
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	private int getLeftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	
	private int getRightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	
	private int getParent(int index) {
		return items[getParentIndex(index)];
	}
	
	private void swap(int one, int two) {
		int temp = items[one];
		items[one] = items[two];
		items[two] = temp;
	}
	
	private void ensureCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity*2);
			capacity *= 2;
		}
	}
	
	//Just checks the min element
	public int peek() {
		if (size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	//removes the min element
	public int poll() {
		if (size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size -1];
		size--;
		heapifyDown();
		return item;
	}
	
	public void add(int item) {
		ensureCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	public void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if(items[index] < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}
	
	public void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && getParent(index) > items[index]) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}

}
