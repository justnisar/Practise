import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwinArrays {

    private static TreeMap<Integer,ArrayList<Integer>> tm1;
	private static TreeMap<Integer,ArrayList<Integer>> tm2;
	
	public static void init(){
		tm1 = new TreeMap<Integer,ArrayList<Integer> >();
		tm2 = new TreeMap<Integer,ArrayList<Integer> >();
	}
	
	public static void addToTreeMap(TreeMap<Integer,ArrayList<Integer>> tm, int[] array){
		for(int i = 0 ; i < array.length ; i++){
        	if(!tm.containsKey(array[i])){
        		ArrayList<Integer> valueList = new ArrayList<Integer>();
        		valueList.add(i);
        		tm.put(array[i],valueList);
        	}
        	else{
        		ArrayList<Integer> valueList = tm.get(array[i]);
        		valueList.add(i);
        		tm.put(array[i],valueList);
        	}
        }
	}
	
	public static int twinArrays(int[] ar1, int[] ar2){
		// Complete this function
        addToTreeMap(tm1,ar1);
        addToTreeMap(tm2,ar2);
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, ArrayList<Integer> > entry1 : tm1.entrySet()){
            int key1 = entry1.getKey();
            ArrayList<Integer> valueList1 = entry1.getValue();
        	for(Map.Entry<Integer, ArrayList<Integer>> entry2 : tm2.entrySet()){
        		int key2 = entry2.getKey();
        		ArrayList<Integer> valueList2 = entry2.getValue();
        		/*
        		 * If the indexes of the keys in the arrays
        		 * are different, we can add them  
        		 */
                if(!valueList1.equals(valueList2) && key1 + key2 < min){
                    min = key1 + key2;
        			break;
                }
                /*
                 * A case like {1,1,1} and {1,1,1}
                 * The index lists for both the keys '1'
                 * in the arrays is the same 
                 */
                if(valueList1.equals(valueList2) && valueList1.size() != 1 && key1 + key2 < min){
        			min = key1 + key2;
        			break;
        		}
        		
        	}
        }
       
        return min;
    }
    public static void main(String[] args) {
        init();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar1 = new int[n];
        for(int ar1_i = 0; ar1_i < n; ar1_i++){
            ar1[ar1_i] = in.nextInt();
        }
        int[] ar2 = new int[n];
        for(int ar2_i = 0; ar2_i < n; ar2_i++){
            ar2[ar2_i] = in.nextInt();
        }
        int result = twinArrays(ar1, ar2);
        System.out.println(result);
    }
}
