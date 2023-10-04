class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> mergedIntervals = new ArrayList<>();
        // Sort the arr based on the first intervals
        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0],interval2[0]));

        int [] currentInterval= intervals[0];
        mergedIntervals.add(currentInterval);
        for(int [] interval : intervals){
            int currentEnd = currentInterval[1];
            int nextEnd = interval[1];
            if(overlaps(currentInterval, interval)){
                // If current interval overlaps with the previous interval, 
                // then merge it with prev
                currentInterval[1] = Math.max(nextEnd, currentEnd);
            } else {
                // End the overlap interval and start a new one.
                currentInterval = interval;
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public boolean overlaps(int [] interval1, int [] interval2){
        return interval1[1] >= interval2[0];
    }
}