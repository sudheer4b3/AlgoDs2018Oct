package com.mine.myString;

import java.util.ArrayList;
import java.util.List;
 
public class FirstNonReapeatingCharFromStream 
{
    final static int MAX_CHAR = 256;
     
    static void findFirstNonRepeating()
    {
        // inDLL[x] contains pointer to a DLL node if x is present 
        // in DLL. If x is not present, then inDLL[x] is NULL
        List<Character> inDLL =new ArrayList<Character>();
         
        // repeated[x] is true if x is repeated two or more times.
        // If x is not seen so far or x is seen only once. then 
        // repeated[x] is false
        boolean[] repeated =new boolean[MAX_CHAR];
         
        // Let us consider following stream and see the process
        String stream = "geeksforgeeksandgeeksquizfor";
        for (int i=0;i < stream.length();i++)
        {
            char x = stream.charAt(i);
            System.out.println("Reading "+ x +" from stream n");
             
            // We process this character only if it has not occurred
            // or occurred only once. repeated[x] is true if x is 
            // repeated twice or more.s
            if(!repeated[x])
            {
                // If the character is not in DLL, then add this at 
                // the end of DLL.
                if(!(inDLL.contains(x)))
                {
                    inDLL.add(x);
                }
                else    // Otherwise remove this character from DLL
                {
                    inDLL.remove((Character)x);
                    repeated[x] = true; // Also mark it as repeated
                }
            }
             
            // Print the current first non-repeating character from
            // stream
            if(inDLL.size() != 0)
            {
                System.out.print("First non-repeating character so far is ");
                System.out.println(inDLL.get(0));
            }
        }    
    }
     
    /* Driver program to test above function */
    public static void main(String[] args) 
    {
        findFirstNonRepeating();
    }
}

/*
 * The idea is to use a DLL (Doubly Linked List) to efficiently get the first non-repeating 
 * character from a stream. The DLL contains all non-repeating characters in order, 
 * i.e., the head of DLL contains first non-repeating character, 
 * the second node contains the second non-repeating and so on.
We also maintain two arrays: one array is to maintain characters that are already 
visited two or more times, we call it repeated[], 
the other array is array of pointers to linked list nodes, we call it inDLL[]. 
The size of both arrays is equal to alphabet size which is typically 256.

Create an empty DLL. Also create two arrays inDLL[] and repeated[] of size 256. 
inDLL is an array of pointers to DLL nodes. repeated[] is a boolean array, repeated[x] is true if x is repeated two or more times, otherwise false. inDLL[x] contains pointer to a DLL node if character x is present in DLL, otherwise NULL.
Initialize all entries of inDLL[] as NULL and repeated[] as false.
To get the first non-repeating character, return character at head of DLL.
Following are steps to process a new character ‘x’ in stream.
If repeated[x] is true, ignore this character 
(x is already repeated two or more times in the stream)
If repeated[x] is false and inDLL[x] is NULL (x is seen first time). 
Append x to DLL and store address of new DLL node in inDLL[x].
If repeated[x] is false and inDLL[x] is not NULL (x is seen second time). 
Get DLL node of x using inDLL[x] and remove the node. 
Also, mark inDLL[x] as NULL and repeated[x] as true.
Note that appending a new node to DLL is O(1) operation if we maintain tail pointer.
Removing a node from DLL is also O(1). So both operations, 
addition of new character and finding first non-repeating character take O(1) time.
 * */