import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KeyboardRow {
	
	private HashSet<Character>[] rows;
	public KeyboardRow(){
		String[] str_rows = {"qwertyuiop","asdfghjkl","zxcvbnm"};
		rows = new HashSet[3];
		for(int i = 0 ; i < 3 ; i++){
			rows[i] = new HashSet<Character>();
			for(int j = 0 ; j < str_rows[i].length() ; j++)
				rows[i].add(str_rows[i].charAt(j));
		}
	}
	
	public boolean isPresent(String word){
	  int length = word.length();
	  int flag = 0;
	  for(int i = 0 ; i < 3 ; i++){
	    for(int j = 0 ; j < length ; j++){
	      char ch = word.charAt(j);
	      if(!rows[i].contains(ch)){
	        flag = 1;
	        break;
	      }
	    }
	    if(flag == 0)
	      return true;
	    else
	      flag = 0;
	  }
	  return false;
	}
	
	public String[] findWords(String[] words) {
		List<String> result = new ArrayList<String>();
		int length = words.length;
		for(int i = 0 ; i < length ; i++){
			String word = words[i];
			if(isPresent(word.toLowerCase()))
			  result.add(word);
		}
		
		
		return result.toArray(new String[result.size()]);
				
    }
	
	public void print(String[] str_arr){
	  System.out.println("Printing list");
	  for(int i = 0 ; i < str_arr.length ; i++)
	    System.out.println(str_arr[i]);
	}
	
	public static void main(String[] args){
	  String[] str_arr = {"Hello","Alaska","Dad","Peace"}; 
	  KeyboardRow obj = new KeyboardRow();
	  
	  obj.print(obj.findWords(str_arr));
	}
	
	
}
