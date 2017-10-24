import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    
    private HashMap<String,Integer> map;
    public Solution(){
        map = new HashMap<String,Integer>();
    }
    
    public String[] getMinimumIndex(String[] list1,String[] list2){
        for(int i = 0 ; i < list1.length ; i++)
          map.put(list1[i], i);
        int min = Integer.MAX_VALUE;
        List<String> result = new ArrayList<String>();
        for(int i = 0 ; i < list2.length ;i++){
          String str = list2[i];
          if(map.containsKey(str)){
            int valueInMap = map.get(str);
            if(result.size() == 0){
              min = i + valueInMap;
              result.add(str);
            }
            else if(i + valueInMap < min){
              min = i + valueInMap;
              result.clear();
              result.add(str);
            }
            else if(i + valueInMap == min){
              result.add(str);
            }
          }
        }
        
        
        return (String[])result.toArray();
    }
    
    public String[] findRestaurant(String[] list1, String[] list2) {

        if(list1.length > list2.length){
            return getMinimumIndex(list1,list2);
        }
        else{
            return getMinimumIndex(list2,list1);
        }
    }
}