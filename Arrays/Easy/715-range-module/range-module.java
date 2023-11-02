class RangeModule {
    class Range {
        int start, end;
        Range(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    List<Range> ranges;
    int n;
    public RangeModule() {
        ranges = new ArrayList<>();
    }
    
    public void addRange(int left, int right) {
        int pos = 0; 
        for(int i=0; i<ranges.size(); i++,pos++) {
            if(left < ranges.get(i).start) {
                break;
            }
        }
        ranges.add(pos, new Range(left, right));
        mergeIntervals();
    }

    private void mergeIntervals() {
        List<Range> newRanges = new ArrayList<>();
        
        // curr interval start <= new interval end -> overalp

        for(Range range: ranges) {
            int n = newRanges.size();
            if(newRanges.isEmpty() || newRanges.get(n-1).end < range.start) {
                newRanges.add(range);
            } else {
                newRanges.get(n-1).end = Math.max(range.end, newRanges.get(n-1).end);
            }
        }

        ranges = newRanges;
    }
    
    public boolean queryRange(int left, int right) {
        for(Range range: ranges) {
            // System.out.println(range.start + " " + range.end);
            if(range.start <= left && range.end >= right) {
                return true;
            }
        }

        return false;
    }
    
    public void removeRange(int left, int right) {
        List<Range> newRange = new ArrayList<>();
        for(Range range: ranges) {
            if(left <= range.start && right>=range.end) {
                continue;
            } else if (left >= range.end || right <= range.start){
                // outside
                newRange.add(range);
            } else if (left < range.start){
                newRange.add(new Range(right, range.end));
            } else if (right > range.end) {
                newRange.add(new Range(range.start, left));
            } else {
                newRange.add(new Range(range.start, left));
                newRange.add(new Range(right, range.end));
            }
        }

        ranges = newRange;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */