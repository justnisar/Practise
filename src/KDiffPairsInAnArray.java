import java.util.HashMap;

public class KDiffPairsInAnArray {
  public int findPairs(int[] nums, int k) {
    int length = nums.length;
    HashMap<Integer,Integer> mapping = new HashMap<Integer,Integer>();
    int result = 0;
    for(int i = 0 ; i < length ; i++)
      mapping.put(nums[i],i);
    
    for(int i = 0 ; i < length ; i++){
      int target = k - nums[i];
      if(mapping.containsKey(target)){
        int index = mapping.get(target);
      }
    }
    
    return 0;
    
}
}
