import java.util.HashMap;
import java.util.Map;
public class ConvertANumberToHexadecimal {
  
  private HashMap<Integer,Character> mapping;
  public ConvertANumberToHexadecimal(){
    mapping = new HashMap<Integer,Character>();
    for(int i = 0 ; i < 10 ; i++)
      mapping.put(i, (char)(i + 48));
    for(int i = 'a' ; i <= 'f' ; i++)
      mapping.put(i - 87, (char)i);    
  }

  public String toHex(int num) {
    StringBuffer result = new StringBuffer();
    while(num != 0){
      int reminder = num & 15;
      result.append(mapping.get(reminder));
      num = num >>> 4;
    }
    return result.reverse().toString();
  }
  
  public static void main(String[] args){
    ConvertANumberToHexadecimal obj = new ConvertANumberToHexadecimal();
    System.out.println(obj.toHex(-1));
  }
  
}
