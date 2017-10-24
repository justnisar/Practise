import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
 
public class MergeIntervals {
  public List<Interval> merge(List<Interval> intervals) {
    //base case
    if(intervals.size() <= 1)
      return intervals;
    
    List<Interval> result = new ArrayList<Interval>();
    // Sort the given interval list based on start time
    Collections.sort(intervals, new Comparator<Interval>(){
      @Override
      public int compare(Interval o1, Interval o2) {
        // TODO Auto-generated method stub
        return o1.start - o2.start;
      }
    });
    result.add(intervals.get(0));
    for(int i = 1 ; i < intervals.size() ;i++){
      
      Interval current = intervals.get(i);
      Interval prev = result.get(result.size() - 1);
      if(current.start >= prev.start && current.end <= prev.end){
        int max = Math.max(prev.end, current.end);
        result.remove(result.size() - 1);
        result.add(new Interval(prev.start,max));
      }
      else{
        result.add(current);
      }
    }
    
    return result;
  }
}
