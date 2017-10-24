
public class ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    int[] result = new int[length];
    result[0] = 1;
    for(int i = 1 ; i < length ; i++)
      result[i] = result[i-1] * nums[i-1];
    int temp = 1;
    for(int i = length - 1 ; i >= 0 ; i--){
      result[i] = result[i] * temp;
      temp = temp * nums[i];
    }
    return result;
  }
}
