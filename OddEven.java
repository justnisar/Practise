
public class OddEven {
	
	public void swap(int[] array,int left,int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public void distributeEvenOdd(int[] array){
		int left = 0;
		int right = array.length - 1;
		while(left < right){
			if(array[left]%2 == 0)
				left++;
			else if(array[left]%2 == 1&& array[right]%2 == 1)
				right--;
			else{
				swap(array,left,right);
				left++;
				right--;
			}
		}
	}
	
	public void print(int[] array){
		for(int number : array)
			System.out.print(number + " ");
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] array = {1,4,2,5,7,3,6,9,8};
		OddEven obj = new OddEven();
		obj.print(array);
		obj.distributeEvenOdd(array);
		obj.print(array);
	}
}

