c class Sorting1 {

	public void swap(char[] array,int left,int right){
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public int partition(char[] array,int start,int end){
		int pivot = array[end];
		int index = start;
		for(int i = start ; i < end ; i++){
			if(array[i] <= pivot){
				swap(array,i,index);
				index++;
			}
		}
		swap(array,index,end);
		return index;
	}
	
	public void qsort(char[] array,int start,int end){
		if(start > end)
			return;
		int index = partition(array,start,end);
		qsort(array,start,index - 1);
		qsort(array,index + 1,end);
	}
	
	public void print(char[] array){
		for(char ch : array)
			System.out.print(ch + " ");
		System.out.println();
	}
	
	public static void main(String[] args){
		char[] nuts = {'@', '#', '$', '%', '^','&'};
		char[] bolts = {'$', '%', '&', '^', '@', '#'};
		Sorting1 obj = new Sorting1();
		obj.qsort(nuts,0,nuts.length - 1);
		obj.qsort(bolts,0,bolts.length - 1);
		obj.print(nuts);
		obj.print(bolts);
		
	}
	
}

