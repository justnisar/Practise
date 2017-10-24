import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
  public int[] nextGreaterElement(int[] findNums, int[] nums) {
   int length = findNums.length;
   int[] result = new int[length];
   length = nums.length;
   Stack<Integer> stack = new Stack<Integer>();
   HashMap<Integer,Integer> mapping = new HashMap<Integer,Integer>();
   for(int i = 0 ; i < length ; i++){
     int current = nums[i];
     while( !stack.empty() && current > stack.peek())
       mapping.put(stack.pop(), current);
     stack.push(current);
   }
   length = findNums.length;
   for(int i = 0 ; i < length ; i++){
     if(mapping.containsKey(findNums[i]))
       result[i] = mapping.get(i);
     else
       result[i] = -1;
   }
   return result;
  }
}
