/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Interval item = null;
        Collections.sort(intervals, new IntervalComparator());
        for (Interval interval : intervals) {
            if (item == null) {
                item = new Interval(interval.start, interval.end);
            } else if (interval.start <= item.end) {
                item.end = Math.max(item.end, interval.end);
            } else {
                res.add(item);
                item = interval;
            }
        }
        res.add(item);
        return res;
    }
}
