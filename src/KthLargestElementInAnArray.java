
public class KthLargestElementInAnArray {
  
  public void swap(int[] array,int x,int y){
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }
  
  public int partition(int[] array,int start,int end){
    int pivot = array[start];
    swap(array,start,end);
    int pos = start;
    for(int i = start; i < end - 1 ; i++){
      if(array[i] >= pivot){
        swap(array,i,pos);
        pos++;
        }
    }
    swap(array,pos,end);
    return pos;
  }
  
  public int quickSelect(int[] array,int start,int end,int k){
    if(start == end)
      return array[start];
    int position = partition(array,start,end);
    if(position == k)
      return array[position];
    else if(position > k)
      return quickSelect(array,start,position - 1,k);
    else
      return quickSelect(array,position + 1,end,k);
  }
  
  public int findKthLargest(int[] nums, int k) {
    int length = nums.length;
    return quickSelect(nums,0,length - 1,k - 1);
  }
  
  public static void main(String[] args){
    KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
    int[] array = {3,2,1,5,6,4};
    System.out.println(obj.quickSelect(array,0,array.length - 1,1));
  }
 
}
