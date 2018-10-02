package com.mine.llsit;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class MergeOverlappingInterval {
	
	public List<Interval> merge(List<Interval> intervals) {
	    if (intervals.size() <= 1)
	        return intervals;
	    
	    // Sort by ascending starting point using an anonymous Comparator
	    //intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
	    Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return (o1.start>o2.start) ? -1 : (o1.start<o2.start)?1:0;
				
			}
        });
	    
	    List<Interval> result = new LinkedList<Interval>();
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;
	    
	    for (Interval interval : intervals) {
	        if (interval.start <= end) // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        else {                     // Disjoint intervals, add the previous one and reset bounds
	            result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }
	    
	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
	}

}
