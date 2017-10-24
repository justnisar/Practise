
public class ReverseString2 {
  public String reverseStr(String s, int k) {
    StringBuffer sb = new StringBuffer(s);
    int length = sb.length();
    int i = 0;
    StringBuffer result = new StringBuffer();
    boolean flag = true;
    while(i < length){
     String temp; 
     if(i + k <= length)
       temp = sb.substring(i,i+k);
     else
       temp = sb.substring(i,length);
     
     if(flag == true){
       result.append(new StringBuffer(temp).reverse());
       flag = false;
     }
     else{
       result.append(temp);
       flag = true;
     }
    i += k; 
    }
    
    
   return result.toString();
  }
}
